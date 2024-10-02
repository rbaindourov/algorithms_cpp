
// 383. Ransom Note
// https://leetcode.com/problems/ransom-note/
// my solution
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] noteFrequency = new int[26];
        int[] magazineFrequency = new int[26];

        for( char c : ransomNote.toCharArray() ){
            noteFrequency[c-'a']++;
        }

        for( char c : magazine.toCharArray() ){
            magazineFrequency[c-'a']++;
        }

        for( int i = 0; i < 26; i++){
            if(magazineFrequency[i]-noteFrequency[i]<0)
                return false;
        }

        return true;
    }
}


//best solution
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] letters = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, letters[c % 26]);
            if (i == -1) return false;
            letters[c % 26] = i + 1;
        }
        return true;


        // HashMap<Character, Integer> set = new HashMap<>();  

        // //add magazine to set
        // for(char c : magazine.toCharArray()) set.put(c, set.getOrDefault(c, 0) + 1);

        // //check is contains by count
        // for(char c : ransomNote.toCharArray()){ 
        //     if(set.containsKey(c)){ 
        //         set.put(c, set.get(c) - 1);

        //         if (set.get(c) == 0) set.remove(c);
        //     }
        //     else return false;
        // }

        // return true;    
    }
}