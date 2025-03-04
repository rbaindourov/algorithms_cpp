#include <iostream>
#include <thread>
#include <vector>
#include <csignal>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>
#include <atomic>
#include <mutex>
#include <set>
#include "client_handler.h"
#include "config.h"
#include "signal_handler.h"

using namespace std;

set<int> activeClients;
mutex clientsMutex;
atomic<bool> running(true); // Shared flag to control server shutdown
mutex ioMutex; // Mutex for synchronized logging
int serverSocket = -1;



int main() {
    // Register the signal handler
    signal(SIGINT, signalHandler);


    // Create a socket
    serverSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (serverSocket == -1) {
        cerr << "Failed to create socket." << endl;
        return 1;
    }


    int opt = 1; // Value for the option
    if (setsockopt(serverSocket, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt)) < 0) {
        cerr << "Failed to set SO_REUSEADDR option." << endl;
        close(serverSocket); // Close the socket and exit
        return 1;
    }


    sockaddr_in serverAddr{};
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(SERVER_PORT);
    serverAddr.sin_addr.s_addr = INADDR_ANY;

    if (bind(serverSocket, (sockaddr*)&serverAddr, sizeof(serverAddr)) == -1) {
        cerr << "Failed to bind socket." << endl;
        close(serverSocket);
        return 1;
    }

    if (listen(serverSocket, 10) == -1) {
        cerr << "Failed to listen on socket." << endl;
        close(serverSocket);
        return 1;
    }

    // Main loop
    vector<thread> clientThreads;

    while (running.load()) {
        sockaddr_in clientAddr{};
        socklen_t addrLen = sizeof(clientAddr);

        int clientSocket = accept(serverSocket, (sockaddr*)&clientAddr, &addrLen);
        if (clientSocket == -1) {
            if (!running.load()) break; // Stop if shutting down
            continue;
        }

        lock_guard<mutex> lock(ioMutex);
        cout << "New client connected!" << endl;

        // Spawn a client thread
        clientThreads.emplace_back(thread(handleClient, clientSocket));
    }

    // Join all threads
    for (auto& thread : clientThreads) {
        if (thread.joinable()) {
            thread.join();
        }
    }

    cout << "Server shutting down..." << endl;
    return 0;
}