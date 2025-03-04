//
// Created by robert on 12/18/24.
//
#include <iostream>
#include <string>
#include <vector>
#include <chrono>

using namespace std;

string longestPalindrome(string s){
  
if (s.empty()) return "";

int start = 0, maxLength = 1; // Initialize the starting index and max length for the palindrome

for (int i = 0; i < s.size(); ++i) {
    // Check for odd-length palindromes
    int left = i, right = i;
    while (left >= 0 && right < s.size() && s[left] == s[right]) {
        if (right - left + 1 > maxLength) {
            start = left;
            maxLength = right - left + 1;
        }
        --left;
        ++right;
    }
    // Check for even-length palindromes
    left = i; 
    right = i + 1;
    while (left >= 0 && right < s.size() && s[left] == s[right]) {
        if (right - left + 1 > maxLength) {
            start = left;
            maxLength = right - left + 1;
        }
        --left;
        ++right;
    }
}

return s.substr(start, maxLength);


}


string longestPalindrome2(string s) {
    // preprocess insert:
    // '#' balance odd/even len, '^$' avoid bound check
    string processedS = "^#";
    for (char c : s)
        processedS += c, processedS += "#";
    processedS += "$";

    int n = processedS.length();
    vector<int> paliRadii(n, 0);
    int curCenter = 0, curRight = 0;    // rightmost pali
    int maxCenter = 0, maxLen = 0;      // longest pali

    for (int i = 1; i < n - 1; i++) {
        // init pali radius: i in rightmost pali?
        // n: default = 0
        // y: use left mirror's val if it won't exceed pali right bound
        if (i < curRight)
            paliRadii[i] = min(curRight - i, paliRadii[2 * curCenter - i]);

        // expand pali radius: check char
        while (processedS[i + paliRadii[i] + 1] == processedS[i - paliRadii[i] - 1])
            paliRadii[i]++;

        // update rightmost pali if i exceeds
        if (i + paliRadii[i] > curRight) {
            curCenter = i;
            curRight = i + paliRadii[i];
        }

        // update max
        if (paliRadii[i] > maxLen) {
            maxCenter = i;
            maxLen = paliRadii[i];
        }
    }

    return s.substr((maxCenter - maxLen) / 2, maxLen); // cal original start id
}

int main() {

    auto start1 = chrono::high_resolution_clock::now();
    cout << longestPalindrome("abccccdd") << endl;
    auto end1 = chrono::high_resolution_clock::now();
    cout << "Method 1 took: " << chrono::duration_cast<chrono::microseconds>(end1 - start1).count() <<
            " microseconds\n";

    auto start2 = chrono::high_resolution_clock::now();
    cout << longestPalindrome2("abccccdd") << endl;
    auto end2 = chrono::high_resolution_clock::now();
    cout << "Method 2 took: " << chrono::duration_cast<chrono::microseconds>(end2 - start2).count() <<
            " microseconds\n";
}
