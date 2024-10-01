class RepeatedCharacter {
    public char repeatedCharacter(String s) {

        int[] frequency =  new int[26];
        for( char c : s.toCharArray() ){
            if( ++frequency[c-'a'] > 1){
                 return c;
            }
        }

        throw new IllegalArgumentException("s should contain at least one repeated letter");

    }

    //main
    public static void main(String[] args) {
        RepeatedCharacter sol = new RepeatedCharacter();
        System.out.println(sol.repeatedCharacter("abccbaacz"));
    }

}