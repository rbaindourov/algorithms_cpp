#include <iostream>
#include <string>
#include <vector>
#include <array>
#include <cstring>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>

using namespace std;

// Process stream data into 4-character chunks
void processStream(const string& data, string& leftoverBuffer, vector<array<char, 4>>& chunks) {
    string streamData = leftoverBuffer + data; // Combine leftover buffer with new input
    size_t i = 0;

    // Process complete chunks of 4 characters
    for (; i + 4 <= streamData.size(); i += 4) {
        array<char, 4> chunk = {streamData[i], streamData[i + 1], streamData[i + 2], streamData[i + 3]};
        chunks.push_back(chunk);
    }

    // Store leftover characters back in the buffer
    leftoverBuffer = streamData.substr(i);
}

// Display the chunks
void displayChunks(const vector<array<char, 4>>& chunks) {
    for (const auto& chunk : chunks) {
        cout << "{ ";
        for (char c : chunk) {
            if (c == 0) {
                cout << "'\\0' ";
            } else {
                cout << "'" << c << "' ";
            }
        }
        cout << "}" << endl;
    }
}

// Server setup and execution
int main() {
    // Create a socket
    int serverSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (serverSocket == -1) {
        cerr << "Failed to create socket." << endl;
        return 1;
    }
    
    // Server address setup
    sockaddr_in serverAddr{};
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(80);         // Port 80
    serverAddr.sin_addr.s_addr = INADDR_ANY; // Listen on all interfaces

    // Bind the socket to the address
    if (bind(serverSocket, (sockaddr*)&serverAddr, sizeof(serverAddr)) == -1) {
        cerr << "Failed to bind socket to port 80. Note: Port 80 requires root privileges!" << endl;
        close(serverSocket);
        return 1;
    }

    // Start listening on the socket
    if (listen(serverSocket, 10) == -1) {
        cerr << "Failed to listen on socket." << endl;
        close(serverSocket);
        return 1;
    }

    cout << "Server is listening on port 80..." << endl;

    // Accept and handle client connections
    sockaddr_in clientAddr{};
    socklen_t clientAddrSize = sizeof(clientAddr);
    int clientSocket = accept(serverSocket, (sockaddr*)&clientAddr, &clientAddrSize);
    if (clientSocket == -1) {
        cerr << "Failed to accept client connection." << endl;
        close(serverSocket);
        return 1;
    }

    cout << "Client connected..." << endl;

    // Variables for stream processing
    char buffer[1024];
    string leftoverBuffer;
    vector<array<char, 4>> chunks;

    // Read data from client
    while (true) {
        memset(buffer, 0, sizeof(buffer));
        ssize_t bytesReceived = recv(clientSocket, buffer, sizeof(buffer) - 1, 0);
        if (bytesReceived <= 0) { // Connection closed or error
            cout << "Client disconnected or error occurred." << endl;
            break;
        }

        // Convert received data into a string
        string data(buffer, bytesReceived);

        // Process the stream into chunks
        processStream(data, leftoverBuffer, chunks);

        // Display the chunks
        displayChunks(chunks);
        chunks.clear(); // Clear chunks to prepare for the next round of processing
    }

    // Process any leftover data at the end
    if (!leftoverBuffer.empty()) {
        array<char, 4> finalChunk = {0, 0, 0, 0};
        for (size_t i = 0; i < leftoverBuffer.size(); ++i) {
            finalChunk[i] = leftoverBuffer[i];
        }
        chunks.push_back(finalChunk);
        displayChunks(chunks);
    }

    // Cleanup
    close(clientSocket);
    close(serverSocket);
    cout << "Server shutdown successfully." << endl;

    return 0;
}