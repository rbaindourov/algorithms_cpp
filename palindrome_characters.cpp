#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

// Function to compute the LPS array (used in KMP algorithm)
vector<int> computeLPS(const string& str) {
    int n = str.length();
    vector<int> lps(n, 0); // LPS array
    int len = 0;          // Length of previous longest prefix suffix
    int i = 1;

    // Compute LPS array
    while (i < n) {
        if (str[i] == str[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1]; // Backtrack
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}

// Function to find minimum characters to add at front to make the string palindrome
int minCharsToMakePalindrome(const string& s) {
    string reversedStr = s;
    reverse(reversedStr.begin(), reversedStr.end());

    // Create the concatenated string
    string temp = s + "$" + reversedStr;

    // Compute LPS array for the concatenated string
    vector<int> lps = computeLPS(temp);

    // Length of the longest palindromic suffix
    int longestPalindromicPrefix = lps.back();

    // Minimum characters to add = length of s - longest palindromic prefix
    return s.length() - longestPalindromicPrefix;
}

int main() {
    string s;
    cout << "Enter string: ";
    cin >> s;

    int result = minCharsToMakePalindrome(s);

    cout << "Minimum characters to add: " << result << endl;

    return 0;
}