import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isPalindrome(int x) {
        String xString = Integer.toString(x);
        int n = xString.length();
        
        for( int i =0; i<n/2; i++){
            if(xString.charAt(i)!= xString.charAt(n-i-1))
                return false;
        }

        return true;
    }

    public static Map<Character, Integer> createRomanNumeralMap() {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }   
    //roman to integer
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = createRomanNumeralMap();
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i); 
            int currentValue = romanMap.get(currentChar);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;   
        }
        return result;
    }
}       




//test cases
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(121)); // true
        System.out.println(sol.isPalindrome(-121)); // false
        System.out.println(sol.isPalindrome(10)); // false
    }
}