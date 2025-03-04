#ifndef CONFIG_H
#define CONFIG_H

#include <vector>

// Port number
constexpr int SERVER_PORT = 8080;

// Bit remap table
const std::vector<int> remapBits = {0, 8, 16, 24, 1, 9, 17, 25, 2, 10, 18, 26,
                         3, 11, 19, 27, 4, 12, 20, 28, 5, 13, 21, 29,
                         6, 14, 22, 30, 7, 15, 23, 31};


#endif // CONFIG_H