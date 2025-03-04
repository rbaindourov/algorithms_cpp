#include "client_handler.h"
#include "utils.h"
#include "config.h"
#include <iostream>
#include <cstring>
#include <sys/socket.h>
#include <unistd.h>
#include <atomic>
#include <mutex>
#include <arpa/inet.h>
#include <thread>
#include <vector>
#include <array>
#include <set>
#include <csignal>
#include <cstdint>
#include <bitset>
#include "server_listener.h"

using namespace std;

void handleClient(int clientSocket  ) {


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