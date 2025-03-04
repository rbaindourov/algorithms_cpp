//
// Created by robert on 12/13/24.
//
#include <iostream>
#include <thread>
#include <vector>
#include <array>
#include <set>
#include <csignal>
#include <cstdint>
#include <mutex>
#include <atomic>
#include <netinet/in.h>

#include "server_listener.h"

using namespace std;

#ifndef SIGNAL_HANDLER_H
#define SIGNAL_HANDLER_H

void signalHandler(int signal) {
    if (signal == SIGINT) {
        lock_guard<mutex> lock(ioMutex);
        cout << "\nCTRL+C detected! Shutting down the server..." << endl;
        running.store(false);

        // Close the server socket
        if (serverSocket != -1) {
            shutdown(serverSocket, SHUT_RDWR);
            close(serverSocket);
        }

        // Close all active client sockets
        {
            lock_guard<mutex> lock(clientsMutex); // Ensure thread safety
            for (int clientSocket : activeClients) {
                shutdown(clientSocket, SHUT_RDWR); // Interrupt recv()
                close(clientSocket);
            }
            activeClients.clear(); // Remove all clients from the set
        }
    }
}
#endif //SIGNAL_HANDLER_H
