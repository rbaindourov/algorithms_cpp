import java.util.*;

public class UncommonWords {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Step 1: Combine both sentences into a single string
        String[] words = (s1 + " " + s2).split(" ");
        
        // Step 2: Use a HashMap to count occurrences of each word
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Step 3: Collect words that occur exactly once
        List<String> uncommonWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }
        
        // Return the list as an array
        return uncommonWords.toArray(new String[0]);
    }

    public static void main(String[] args) {
        UncommonWords solution = new UncommonWords();
        
        // Example 1
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(solution.uncommonFromSentences(s1, s2))); 
        // Output: ["sweet", "sour"]
        
        // Example 2
        String s1_2 = "apple apple";
        String s2_2 = "banana";
        System.out.println(Arrays.toString(solution.uncommonFromSentences(s1_2, s2_2))); 
        // Output: ["banana"]
    }
}
