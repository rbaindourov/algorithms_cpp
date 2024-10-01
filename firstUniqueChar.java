class FirstUniqCharacter {
    public int firstUniqChar(String s) {
        int[] frequency =  new int[123];
        char[] chars = s.toCharArray();
        for( char c : chars )
            frequency[c]++;
        
        for( int i = 0; i < chars.length; i++) {
            if( frequency[chars[i]] == 1 )
                return i;
        }

        return -1;

    }


//main
public static void main(String[] args) {
    FirstUniqCharacter sol = new FirstUniqCharacter();
    System.out.println(sol.firstUniqChar("leetcode")); // 0
    System.out.println(sol.firstUniqChar("loveleetcode")); // 2
    System.out.println(sol.firstUniqChar("aabb")); // -1

} 

}