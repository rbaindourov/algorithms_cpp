//
// Created by robert on 12/15/24.
//

#include "anagram.h"
#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

bool Solution::isAnagram(string s, string t) {
    if( s  == t ) return true;
    if( s.length() != t.length() )  return false;
    sort(t.begin(), t.end());
    sort(s.begin(), s.end());
    return s == t;
 }

int main() {
    Solution solution = Solution();
    cout << solution.isAnagram("anagram", "nagaram") << endl;
    return 0;
}