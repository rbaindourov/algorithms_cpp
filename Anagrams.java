import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // HashMap example
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        System.out.println("HashMap: " + map);

        // ArrayList example
        ArrayList<String> list = new ArrayList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        System.out.println("ArrayList: " + list);

        // Anagram example
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat", "sat", "fog","mog","cat", "dog", "tac", "god", "act", "gog", "ogd", "dog", "gog", "ogd","eat", "tea", "tan", "ate", "nat", "bat", "sat", "fog","mog","cat", "dog", "tac", "god", "act", "gog", "ogd", "dog", "gog", "ogd"};
        var anagramGroups = findAnagrams(words);
        System.out.println("Anagram groups:");
        for (var entry : anagramGroups.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> group = entry.getValue();
            System.out.println("Hash key: " + key + ", Group size: " + group.size() + ", Words: " + group);
        }
    }

    public static HashMap<String, ArrayList<String>> findAnagrams(String[] words) {
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<>();
        
        for (String word : uniqueWords) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            anagramMap.putIfAbsent(sortedWord, new ArrayList<>());
            anagramMap.get(sortedWord).add(word);
        }
        
        // Remove groups with only one word
        anagramMap.entrySet().removeIf(entry -> entry.getValue().size() <= 1);
        
        return anagramMap;
    }
}
