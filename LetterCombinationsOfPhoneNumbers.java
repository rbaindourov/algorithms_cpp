/* 
17. Letter Combinations of a Phone Number
Medium
Topics
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']. */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result, digitToLetters);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result, Map<Character, String> digitToLetters) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(digits, index + 1, path, result, digitToLetters);
            path.deleteCharAt(path.length() - 1);
        }
    }
    //generate test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("234")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(solution.letterCombinations("")); // []
        System.out.println(solution.letterCombinations("2")); // ["a","b","c"]
    }
}





