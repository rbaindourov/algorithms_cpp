import java.util.HashSet;

class CountConsistent {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowedSet = new HashSet<>();
        for( char c : allowed.toCharArray()){
            allowedSet.add(c);
        }
        int count = 0;
        for( String word : words){
            for( char c : word.toCharArray()){
                if( !allowedSet.contains(c) ) {
                    count++;
                    break;
                }
            }
        }
        
        return words.length - count;
    }
}