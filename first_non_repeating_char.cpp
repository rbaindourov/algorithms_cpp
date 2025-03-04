#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

char firstNonRepeatingChar(const string& s) {
    // Step 1: Count frequencies of each character
    unordered_map<char, int> charCount;
    for (char c : s) {
        charCount[c]++;
    }

    // Step 2: Find the first non-repeating character
    for (char c : s) {
        if (charCount[c] == 1) {
            return c; // First non-repeating character found
        }
    }

    // Step 3: No non-repeating character
    return '$';
}

int main() {
    string s = "geeksforgeeks";
    char result = firstNonRepeatingChar(s);

    if (result == '$') {
        cout << -1 << endl; // Follow the note: '$' indicates no non-repeating character
    } else {
        cout << result << endl;
    }

    return 0;
}