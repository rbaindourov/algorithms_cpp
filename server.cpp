#include <iostream>
#include <thread>
#include <vector>
#include <array>
#include <cstring>
#include <string>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>
#include <mutex>
#include <bitset>
#include <atomic>
#include <csignal>
#include <cstdint>
#include <set>
std::set<int> activeClients;
std::mutex clientsMutex;
using namespace std;

// Function to convert 4 chars into a 32-bit integer
uint32_t makeIntegerFromChars(char c1, char c2, char c3, char c4) {
    return (static_cast<uint32_t>(c1) << 24) |
           (static_cast<uint32_t>(c2) << 16) |
           (static_cast<uint32_t>(c3) << 8) |
           (static_cast<uint32_t>(c4));
}

// Function to remap bits of a 32-bit integer
uint32_t remapBitsFunction(uint32_t input, const vector<int>& remapBits) {
    uint32_t output = 0;
    for (size_t i = 0; i < remapBits.size(); ++i) {
        int fromBit = remapBits[i];
        if (fromBit >= 0 && fromBit < 32) {
            uint32_t bit = (input >> fromBit) & 1;
            output |= (bit << i);
        }
    }
    return output;
}

// Constant remap table (example shown here, adjust as needed)
vector<int> remapBits = {0, 8, 16, 24, 1, 9, 17, 25, 2, 10, 18, 26,
                         3, 11, 19, 27, 4, 12, 20, 28, 5, 13, 21, 29,
                         6, 14, 22, 30, 7, 15, 23, 31};
// Global shutdown flag
atomic<bool> running(true);

// Mutex for synchronized I/O (optional for cleaner console output)
mutex ioMutex;


int serverSocket = -1;

// Function to handle a single client connection
void handleClient(int clientSocket) {


    // Add the client socket to the global list
    {
        std::lock_guard<std::mutex> lock(clientsMutex);
        activeClients.insert(clientSocket);
    }

    char buffer[1024];
    string leftoverBuffer;

    while (running.load()) {
        memset(buffer, 0, sizeof(buffer));
        ssize_t bytesReceived = recv(clientSocket, buffer, sizeof(buffer) - 1, 0);
        if (bytesReceived <= 0) {
            lock_guard<mutex> lock(ioMutex);
            cout << "Client disconnected." << endl;
            break;
        }

        string data(buffer, bytesReceived);

        // Process the data in chunks of 4 characters
        vector<uint32_t> processedChunks;
        string streamData = leftoverBuffer + data;
        leftoverBuffer.clear();

        size_t i = 0;
        for (; i + 4 <= streamData.size(); i += 4) {
            uint32_t integer = makeIntegerFromChars(streamData[i + 3], streamData[i + 2], streamData[i + 1], streamData[i] );
            uint32_t remappedInteger = remapBitsFunction(integer, remapBits);
            {
                lock_guard<mutex> lock(ioMutex);
                bitset<32> binary(integer);
                cout << streamData.substr(i, 4) << endl;
                cout << binary.to_string() << endl;
                cout << integer << endl;
                binary = bitset<32>(remappedInteger);
                cout << binary.to_string() << endl;
                cout << remappedInteger << endl;
                cout << endl;
            }
            processedChunks.push_back(remappedInteger);
        }

        // Handle leftover characters
        if (i < streamData.size()) {
            leftoverBuffer = streamData.substr(i);
        }

        // Send processed data back to the client
        for (uint32_t chunk : processedChunks) {
            uint32_t networkOrderChunk = htonl(chunk); // Ensure network byte order
            send(clientSocket, &networkOrderChunk, sizeof(networkOrderChunk), 0);
        }
    }
    // Remove the client socket from the active list and close it
    {
        std::lock_guard<std::mutex> lock(clientsMutex);
        activeClients.erase(clientSocket);
    }
    close(clientSocket);
}

// Signal handler for CTRL+C
void signalHandler(int signal) {
    if (signal == SIGINT) {
        lock_guard<mutex> lock(ioMutex);
        cout << "\nCTRL+C detected! Shutting down the server..." << endl;
        running.store(false); // Set the shutdown flag to false
    }

    // Close the server socket to unblock `accept()`
    if (serverSocket != -1) {
        shutdown(serverSocket, SHUT_RDWR);
        close(serverSocket);
    }

    // Close all active client sockets
    {
        std::lock_guard<std::mutex> lock(clientsMutex); // Ensure thread safety
        for (int clientSocket : activeClients) {
            shutdown(clientSocket, SHUT_RDWR); // Interrupt recv()
            close(clientSocket);
        }
        activeClients.clear(); // Remove all clients from the set
    }
}

int main() {
    // Register the signal handler for SIGINT
    signal(SIGINT, signalHandler);
    // Create a TCP socket
    serverSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (serverSocket == -1) {
        cerr << "Failed to create socket." << endl;
        return 1;
    }

    // Server socket configuration
    sockaddr_in serverAddr{};
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(8080);         // Listen on port 8080
    serverAddr.sin_addr.s_addr = INADDR_ANY;  // Listen on all interfaces

    // Bind the socket
    if (bind(serverSocket, (sockaddr*)&serverAddr, sizeof(serverAddr)) == -1) {
        cerr << "Bind failed. Are you running with sufficient permissions?" << endl;
        close(serverSocket);
        return 1;
    }

    // Start listening
    if (listen(serverSocket, 10) == -1) {
        cerr << "Failed to listen on port 8080." << endl;
        close(serverSocket);
        return 1;
    }

    cout << "Server listening on port 8080..." << endl;

    // Accept multiple clients using threads
    vector<thread> clientThreads;
    while (running.load()) {
        sockaddr_in clientAddr{};
        socklen_t clientAddrSize = sizeof(clientAddr);

        int clientSocket = accept(serverSocket, (sockaddr*)&clientAddr, &clientAddrSize);
        if (clientSocket == -1) {
            if (running.load() == false) break;
            cerr << "Failed to accept client connection." << endl;
            continue;
        }

        lock_guard<mutex> lock(ioMutex);
        cout << "New client connected!" << endl;

        // Spawn a thread to handle the client
        clientThreads.emplace_back(thread(handleClient, clientSocket));
    }

    // Cleanup: Join all threads (optional since this runs indefinitely)
    for (auto& t : clientThreads) {
        if (t.joinable()) {
            t.join();
        }
    }

    close(serverSocket);
    return 0;
}