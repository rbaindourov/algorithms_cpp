//
// Created by robert on 1/2/25.
//
#include <iostream>
#include <string>
using namespace std;

#include <string>

using namespace std;

#include <string>

using namespace std;

string makeFancyString(string s) {
    string result = "";  // This will hold the modified string
    int count = 0;  // Track the count of consecutive characters
    char prev = '\0';  // Initialize to a character not in the string

    // Iterate through the string using a range-based for loop
    for (auto c : s) {
        if (prev != c) {
            prev = c;
            count = 1;  // Reset count when we encounter a new character
        } else {
            count++;
        }

        // Only append the character if the count is less than or equal to 2
        if (count <= 2) {
            result += c;
        }
    }

    return result;
}


int main() {
  string s = "aaabaaaa";
  cout << makeFancyString(s);
}