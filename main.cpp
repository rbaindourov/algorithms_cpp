#include <iostream>
#include <bitset>
#include <vector>
#include <array>
#include <cstdint>

using namespace std;

// Function to create a 32-bit integer from 4 chars
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

void processAndDisplay(const array<char, 4>& chars, const vector<int>& remapBits) {
    // Step 1: Create a 32-bit integer from the reversed chars
    uint32_t bitmaskRaw = makeIntegerFromChars(chars[3], chars[2], chars[1], chars[0]);

    // Step 2: Remap the bits
    uint32_t bitmaskEncoded = remapBitsFunction(bitmaskRaw, remapBits);

    // Step 3: Display both raw and encoded values
    bitset<32> binary(bitmaskRaw);
    cout << "Raw Binary representation: " << binary.to_string() << endl;
    cout << "Raw Integer value: " << bitmaskRaw << endl;

    binary = bitmaskEncoded;
    cout << "Encoded Binary representation: " << binary.to_string() << endl;
    cout << "Encoded Integer value: " << bitmaskEncoded << endl;
}

int main() {
    // Bit remapping array (example implementation)
    vector<int> remapBits = {0, 8, 16, 24, 1, 9, 17, 25, 2, 10, 18, 26,
                             3, 11, 19, 27, 4, 12, 20, 28, 5, 13, 21, 29,
                             6, 14, 22, 30, 7, 15, 23, 31};

    // Define test cases using a vector of arrays
    vector<array<char, 4>> testCases = {
        array<char, 4>{ 'A', 0, 0, 0 },
        array<char, 4>{'F', 'R', 'E', 'D'},
        array<char, 4>{' ', ':', '^', ')'},  // Example of adding another test case
        array<char, 4>{ 'f', 'o', 'o', 0},
        array<char, 4>{' ', 'f', 'o', 'o'},
        array<char, 4>{'f', 'o', 'o', 't'},
        array<char, 4>{'B', 'I', 'R', 'D'},
        array<char, 4>{'.', '.', '.', '.'},
        array<char, 4>{'^', '^', '^', '^'},
        array<char, 4>{'W', 'o', 'o', 't'},
        array<char, 4>{ 'n', 'o', 0, 0 },
        array<char, 4>{'r', 'b', 'a', 'i'},
        array<char, 4>{'r', 'o', 'b', 'e'},
    };

    // Loop over test cases and process them
    for (const auto& testCase : testCases) {
        cout << "Processing array: {'" << testCase[0] << "', '"
             << testCase[1] << "', '" << testCase[2] << "', '"
             << testCase[3] << "'}:\n";
        processAndDisplay(testCase, remapBits);
        cout << "\n";
    }

    return 0;
}