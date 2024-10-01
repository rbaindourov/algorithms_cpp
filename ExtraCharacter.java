import java.util.HashSet;
import java.util.Set;

public class ExtraCharacter {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }
        
        // dp[i] represents the minimum extra characters if we start from index i
        int[] dp = new int[n + 1];
        
        // Initialize dp[n] = 0, as no extra characters when starting at the end of the string
        dp[n] = 0;
        
        // Fill the dp array from the end of the string towards the beginning
        for (int i = n - 1; i >= 0; i--) {
            // Assume the current character is extra
            dp[i] = dp[i + 1] + 1;
            
            // Try to match substrings starting at index i
            for (int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (dict.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }
        
        return dp[0];
    }

    public static void main(String[] args) {
        ExtraCharacter sol = new ExtraCharacter();
        
        String s1 = "leetscode";
        String[] dict1 = {"leet", "code", "leetcode"};
        System.out.println(sol.minExtraChar(s1, dict1)); // Output: 1
        
        String s2 = "sayhelloworld";
        String[] dict2 = {"hello", "world"};
        System.out.println(sol.minExtraChar(s2, dict2)); // Output: 3
    }
}
