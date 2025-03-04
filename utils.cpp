#include "utils.h"

// Converts 4 chars into a 32-bit integer
uint32_t makeIntegerFromChars(char c1, char c2, char c3, char c4) {
    return (static_cast<uint32_t>(c1) << 24) |
           (static_cast<uint32_t>(c2) << 16) |
           (static_cast<uint32_t>(c3) << 8) |
           (static_cast<uint32_t>(c4));
}

// Remaps bits of a 32-bit integer
uint32_t remapBitsFunction(uint32_t input, const std::vector<int>& remapBits) {
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