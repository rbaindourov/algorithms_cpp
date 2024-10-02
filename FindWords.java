import java.util.*;

class FindWords {
    public String[] findWords(String[] words) {
        Set<Character> rowOne = new HashSet<>(Arrays.asList('q','w','e','r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> rowTwo = new HashSet<>(Arrays.asList('a','s','d','f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> rowThree = new HashSet<>(Arrays.asList('z','x','c','v', 'b', 'n', 'm'));

        // List to hold the result words
        List<String> result = new ArrayList<>();

        for (String word : words) {
            // Check if the word belongs to a single row
            if (canBeTypedOnOneRow(word.toLowerCase(), rowOne) ||
                canBeTypedOnOneRow(word.toLowerCase(), rowTwo) ||
                canBeTypedOnOneRow(word.toLowerCase(), rowThree)) {
                result.add(word); // If true, add the word to the result
            }
        }

        // Convert the result list to an array and return
        return result.toArray(new String[0]);


    }



    private boolean canBeTypedOnOneRow(String word, Set<Character> row) {
        for (char c : word.toCharArray()) {
            if (!row.contains(c)) {
                return false; // If any character is not in the row, return false
            }
        }
        return true; // All characters belong to the same row
    }

}


/*
 * 
 * Best solution
 * 
 * 
 
 class Solution {
    public String[] findWords(String[] words) {
       String key1="qwertyuiopQWERTYUIOP";
        String key2="asdfghjklASLKDFHGJ";
       String key3="mznxcbvZMXNCBV";
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<words.length;i++){
             int count=0;
             for(int j=0;j<words[i].length();j++){
                 if(key1.indexOf(words[i].charAt(j))!=-1){
                    count++;
                    break;
                 }
             }
             for(int j=0;j<words[i].length();j++){
                 if(key2.indexOf(words[i].charAt(j))!=-1){
                    count++;
                    break;
                 }
             }
             for(int j=0;j<words[i].length();j++){
                 if(key3.indexOf(words[i].charAt(j))!=-1){
                    count++;
                    break;
                 }
             }
             if(count==1){
                list.add(words[i]);
             }
        }
        String[] arr=new String[list.size()];
        int k=0;
        for(String i:list){
             arr[k]=i;
             k++;
        }
        return arr;
    }
}

 */