public class Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int left = 0, right = s.length()-1;
        if(left == right ) return false;

        while( left < right ){
            if( s.charAt(left) != s.charAt(right))
                return false;
            right--;
            left++;

        }

        return true;
    }


public static void main(String[] args) {
    Palindrome palindrome = new Palindrome();
    System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama")); // Output: true
    System.out.println(palindrome.isPalindrome("Not a palindrome")); // Output: false
    System.out.println(palindrome.isPalindrome("0P")); // Output: false
    System.out.println(palindrome.isPalindrome("a")); // Output: false
    
    
}
}