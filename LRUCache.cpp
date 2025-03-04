//
// Created by robert on 12/19/24.
//
#include <iostream>
#include <unordered_map>
#include <list>
#include <utility>

class LRUCache {
private:
    int capacity; // Maximum capacity of the cache
    std::list<std::pair<int, int>> cacheList; // Doubly linked list to store key-value pairs
    std::unordered_map<int, std::list<std::pair<int, int>>::iterator> cacheMap; // Map to store key and iterator to its position in the list

public:
    LRUCache(int cap) : capacity(cap) {}

    int get(int key) {
        // If key is not in cache
        if (cacheMap.find(key) == cacheMap.end()) {
            return -1; // Not found
        }

        // Move the accessed key-value pair to the front (most recently used)
        auto it = cacheMap[key];
        int value = it->second; // Get the value
        cacheList.erase(it);    // Remove from the current position
        cacheList.push_front({key, value}); // Add to the front
        cacheMap[key] = cacheList.begin(); // Update the iterator in the map

        return value;
    }

    void put(int key, int value) {
        // If key already exists, update its value and move it to the front
        if (cacheMap.find(key) != cacheMap.end()) {
            auto it = cacheMap[key];
            cacheList.erase(it); // Remove from the current position
        } else if (cacheList.size() == capacity) {
            // Cache is full, remove the least recently used item
            auto last = cacheList.back(); // Get the last item
            cacheMap.erase(last.first);   // Remove it from the map
            cacheList.pop_back();         // Remove it from the list
        }

        // Insert the new key-value pair at the front
        cacheList.push_front({key, value});
        cacheMap[key] = cacheList.begin(); // Update the iterator in the map
    }
};

int main() {
    LRUCache lru(3); // Create an LRU Cache with capacity 3

    lru.put(1, 10);
    lru.put(2, 20);
    lru.put(3, 30);

    std::cout << "Get 1: " << lru.get(1) << "\n"; // Should return 10

    lru.put(4, 40); // Evicts key 2 (least recently used)

    std::cout << "Get 2: " << lru.get(2) << "\n"; // Should return -1 (not found)
    std::cout << "Get 3: " << lru.get(3) << "\n"; // Should return 30

    lru.put(5, 50); // Evicts key 1 (least recently used)

    std::cout << "Get 1: " << lru.get(1) << "\n"; // Should return -1 (not found)
    std::cout << "Get 4: " << lru.get(4) << "\n"; // Should return 40
    std::cout << "Get 5: " << lru.get(5) << "\n"; // Should return 50

    return 0;
}
