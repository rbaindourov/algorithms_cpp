//me!
class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length-1;
        char temp;
        Set<Character> vowels = Set.of('a', 'e', 'i',  'o', 'u', 'A', 'E', 'I', 'O', 'U' );

        while( l < r ){
            if( vowels.contains(c[r])){
                if( vowels.contains(c[l]) ){
                    temp = c[r];
                    c[r] = c[l];
                    c[l] = temp;
                    l++;
                    r--;
                }else
                    l++;
            }else
                r--;
        }

        return new String(c);

        
    }
}



//chatgpt
class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length - 1;

        while (l < r) {
            // Move the left pointer until a vowel is found
            while (l < r && !isVowel(c[l])) {
                l++;
            }
            // Move the right pointer until a vowel is found
            while (l < r && !isVowel(c[r])) {
                r--;
            }
            // Swap the vowels at l and r
            if (l < r) {
                char temp = c[l];
                c[l] = c[r];
                c[r] = temp;
                l++;
                r--;
            }
        }

        // Return the result as a string
        return new String(c);
    }

    // Helper method to check if a character is a vowel
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}



//best!
class Solution {
    public String reverseVowels(String s) {
        boolean vowels[] = new boolean[128];

        for(char chr : "aeiouAEIOU".toCharArray()){
            vowels[chr] = true;
        }

        char []arr = s.toCharArray();

        int start = 0; 
        int end = arr.length-1;

        while(start < end){
            if(!vowels[arr[start]]){
                start++;
                continue;
            }
            if(!vowels[arr[end]]){
                end--;
                continue;
            }

            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }

        return String.valueOf(arr);
        
    }
}	
