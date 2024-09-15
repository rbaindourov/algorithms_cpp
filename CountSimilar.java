/* 2506. Count Pairs Of Similar Strings
Easy
Topics
Companies
Hint
You are given a 0-indexed string array words.

Two strings are similar if they consist of the same characters.

For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.
Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1 and the two strings words[i] and words[j] are similar.

 

Example 1:

Input: words = ["aba","aabb","abcd","bac","aabc"]
Output: 2
Explanation: There are 2 pairs that satisfy the conditions:
- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'. 
- i = 3 and j = 4 : both words[3] and words[4] only consist of characters 'a', 'b', and 'c'. 
Example 2:

Input: words = ["aabb","ab","ba"]
Output: 3
Explanation: There are 3 pairs that satisfy the conditions:
- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'. 
- i = 0 and j = 2 : both words[0] and words[2] only consist of characters 'a' and 'b'.
- i = 1 and j = 2 : both words[1] and words[2] only consist of characters 'a' and 'b'.
Example 3:

Input: words = ["nba","cba","dba"]
Output: 0
Explanation: Since there does not exist any pair that satisfies the conditions, we return 0.
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consist of only lowercase English letters. */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CountSimilar {

    public int countSimilar(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSimilar(words[i], words[j])) count++;
            }
        }
        return count;
    }

    public boolean isSimilar(String word1, String word2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        
        for (char c : word1.toCharArray()) set1.add(c);
        for (char c : word2.toCharArray()) set2.add(c);
        
        return set1.equals(set2);
    }

     public int similarPairs(String[] words) {
        Map<String, Integer> signatureCount = new HashMap<>();
        int count = 0;

        for (String word : words) {
            String signature = getSignature(word);
            int freq = signatureCount.getOrDefault(signature, 0);
            count += freq;
            signatureCount.put(signature, freq + 1);
        }

        return count;
    }

    private String getSignature(String word) {
        boolean[] seen = new boolean[26];
        for (char c : word.toCharArray()) {
            seen[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (seen[i]) {
                sb.append((char)('a' + i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountSimilar cs = new CountSimilar();
        String[] words = {"aba","aabb","abcd","bac","aabc"};
        System.out.println(cs.countSimilar(words));
        System.out.println(cs.similarPairs(words));
        String[] words2 = {"aabb","ab","ba"};
        System.out.println(cs.countSimilar(words2));
        System.out.println(cs.similarPairs(words2));
        String[] words3 = {"nba","cba","dba"};
        System.out.println(cs.countSimilar(words3));
        System.out.println(cs.similarPairs(words3));
        String[] words4 = {"a","aa","aaa"};
        System.out.println(cs.countSimilar(words4));
        System.out.println(cs.similarPairs(words4));
    }
}

