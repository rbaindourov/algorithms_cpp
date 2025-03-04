#ifndef SERVER_LISTENER_H
#define SERVER_LISTENER_H

#include <mutex>
#include <set>
#include <atomic>

extern int serverSocket;
extern std::mutex ioMutex;
extern std::atomic<bool> running;
extern std::set<int> activeClients;
extern std::mutex clientsMutex;  // Make the mutex accessible globally

#endif // SERVER_LISTENER_H