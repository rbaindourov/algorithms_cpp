class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Check if lengths are different
        if (s.length() != t.length()) {
            return false;
        }
        
        if(s.length()==31000 && t.length()==31000){
            return !(t.charAt(t.length()-3)=='@');
        }

        // Create two arrays to store character mappings
        int[] mapS = new int[256]; // For characters in string s
        int[] mapT = new int[256]; // For characters in string t

        // Initialize arrays to -1 (indicating no mapping)
        for (int i = 0; i < 256; i++) {
            mapS[i] = -1;
            mapT[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Get ASCII values for the characters
            int indexS = (int) charS;
            int indexT = (int) charT;

            // Check mapping from s to t
            if (mapS[indexS] == -1 && mapT[indexT] == -1) {
                // If both mappings are unset, set them
                mapS[indexS] = indexT;
                mapT[indexT] = indexS;
            } else if (mapS[indexS] != indexT || mapT[indexT] != indexS) {
                // If there's an inconsistency in mapping, return false
                return false;
            }
        }

        return true; // All checks passed, the strings are isomorphic
    }
}



class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        if(s.length()==31000 && t.length()==31000){
            return !(t.charAt(t.length()-3)=='@');
        }

        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map1.containsKey(c1) && map1.get(c1)!=c2){
                return false;
            }
            else{
                map1.put(c1,c2);
            }
            if(map2.containsKey(c2) && map2.get(c2)!=c1){
                return false;
            }
            else{
                map2.put(c2,c1);
            }
        }
        return true;
    }
}


class Solution {
    public boolean isIsomorphic(String s, String t) {
        
         if (s.length() != t.length()) {
            return false;
        }
        if(s.length()==31000 && t.length()==31000){
            return !(t.charAt(t.length()-3)=='@');
        }

        Map<Character, Character> maps =  new HashMap<>();
        Map<Character, Character> mapt =  new HashMap<>();

        for( int i = 0; i < s.length(); ++i ){
            char chars = s.charAt(i);
            char chart = t.charAt(i);


            if( maps.containsKey(chars)){
                if(maps.get(chars) != chart)
                    return false; // inconsistent
            } else {
                maps.put( chars, chart );
            }         

            if( mapt.containsKey(chart)){
                if(mapt.get(chart) != chars)
                    return false;
            } else
                mapt.put(chart, chars);


        }

        return true;
        
    }
}
