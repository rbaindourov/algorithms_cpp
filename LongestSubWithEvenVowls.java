class LongestSubWithEvenVowls {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> seen = new HashMap<>();
        
        seen.put(0, -1);
        int bitmask = 0;
        int maxLen = 0;
        
        for( int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            if( c == 'a' ) bitmask ^= (1 << 0);
            if( c == 'e' ) bitmask ^= (1 << 1);
            if( c == 'i' ) bitmask ^= (1 << 2);
            if( c == 'o' ) bitmask ^= (1 << 3);
            if( c == 'u' ) bitmask ^= (1 << 4);

            if( seen.containsKey(bitmask) ){
                int length = i - seen.get(bitmask);
                maxLen = Math.max( maxLen, length);
            } else {
                seen.put( bitmask, i);
            }
        }

        return maxLen;

    }
}