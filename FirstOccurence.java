/* 
28. Find the Index of the First Occurrence in a String
Easy
Topics
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1. */

class FirstOccurence {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needle.length() > haystack.length()) break;
                String sub = haystack.substring(i, i + needle.length());
                if (sub.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }


/*
 
Code
Code
Testcase
Test Result
Test Result
459. Repeated Substring Pattern
Easy
Topics
Companies
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 */
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder repeated = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    repeated.append(substring);
                }
                if (repeated.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }




    
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad")); // 0
        System.out.println(strStr("leetcode", "leeto")); // -1
        //generate test cases for repeatedSubstring
        System.out.println(repeatedSubstringPattern("abab")); // true
        System.out.println(repeatedSubstringPattern("aba")); // false
        System.out.println(repeatedSubstringPattern("abcabcabcabc")); // true
    }
}