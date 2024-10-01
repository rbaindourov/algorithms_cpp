import java.util.*;

public class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        
        // Convert each person's list of favorite companies into a set for efficient comparison
        List<Set<String>> companySets = new ArrayList<>();
        for (List<String> companies : favoriteCompanies) {
            companySets.add(new HashSet<>(companies));
        }
        
        List<Integer> result = new ArrayList<>();
        
        // For each person i, check if their list is a subset of any other person j's list
        for (int i = 0; i < n; i++) {
            boolean isSubset = false;
            
            // Compare person i's set with every other person j's set
            for (int j = 0; j < n; j++) {
                if (i != j && companySets.get(j).containsAll(companySets.get(i))) {
                    isSubset = true;
                    break;
                }
            }
            
            // If the current person's list is not a subset of anyone else's, add their index
            if (!isSubset) {
                result.add(i);
            }
        }
        
        // Return the result in increasing order (the indices are already processed in order)
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        List<List<String>> favoriteCompanies1 = Arrays.asList(
            Arrays.asList("google", "facebook", "amazon"),
            Arrays.asList("google", "amazon"),
            Arrays.asList("facebook", "amazon"),
            Arrays.asList("google", "facebook", "amazon", "microsoft")
        );
        System.out.println(solution.peopleIndexes(favoriteCompanies1)); // Output: [0, 2, 3]
        
        // Test case 2
        List<List<String>> favoriteCompanies2 = Arrays.asList(
            Arrays.asList("leetcode", "google", "facebook"),
            Arrays.asList("google", "microsoft"),
            Arrays.asList("google", "facebook"),
            Arrays.asList("google"),
            Arrays.asList("amazon")
        );
        System.out.println(solution.peopleIndexes(favoriteCompanies2)); // Output: [0, 1, 4]
    }
}
