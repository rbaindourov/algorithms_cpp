#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>

std::mutex mtx;
std::condition_variable cv;
bool oddTurn = true; // Flag to toggle between odd and even

void printOdd(int max) {
    for (int i = 1; i <= max; i += 2) {
        std::unique_lock<std::mutex> lock(mtx);
        cv.wait(lock, [] { return oddTurn; }); // Wait until it's odd's turn
        std::cout << i << " ";
        oddTurn = false; // Set turn for even
        lock.unlock();
        cv.notify_one(); // Notify the other thread
    }
}

void printEven(int max) {
    for (int i = 2; i <= max; i += 2) {
        std::unique_lock<std::mutex> lock(mtx);
        cv.wait(lock, [] { return !oddTurn; }); // Wait until it's even's turn
        std::cout << i << " ";
        oddTurn = true; // Set turn for odd
        lock.unlock();
        cv.notify_one(); // Notify the other thread
    }
}

int main() {
    int max = 10; // Specify the range
    std::thread t1(printOdd, max);
    std::thread t2(printEven, max);

    t1.join();
    t2.join();

    return 0;
}
//
// Created by robert on 12/19/24.
//
