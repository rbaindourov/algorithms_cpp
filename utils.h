#ifndef UTILS_H
#define UTILS_H

#include <cstdint>
#include <vector>

// Converts 4 chars into a 32-bit integer
uint32_t makeIntegerFromChars(char c1, char c2, char c3, char c4);

// Remaps bits of a 32-bit integer
uint32_t remapBitsFunction(uint32_t input, const std::vector<int>& remapBits);

#endif // UTILS_H


    // Define test cases using a vector of arrays
    vector<array<char, 4>> encodeTestCases = {
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


    vector<uint32_t> decodeTestCases = {  16777217,
        251792692, 79094888, 124807030, 250662636,
        267939702, 251930706, 15794160, 252706800,
        266956663, 53490482, 267485244 ,267463290 };


    // Loop over test cases and process them
    for (const auto& testCase : encodeTestCases) {
        cout << "Processing array: {'" << testCase[0] << "', '"
             << testCase[1] << "', '" << testCase[2] << "', '"
             << testCase[3] << "'}:\n";
        encodeAndDisplay(testCase);
        cout << "\n";
    }


 for (const auto& testCase : decodeTestCases) {
        cout << "Processing array:" << testCase << " :\n";
        decodeAndDisplay(testCase);
        cout << "\n";
    }
