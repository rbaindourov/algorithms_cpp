class RoteateString {
    public boolean rotateString(String s, String goal) {
        
        for(int i = 0; i < s.length(); i++ ) {
            s = s.substring(1) + s.charAt(0);
            if( s.equals(goal) )
                return true;

        }

        return false;
    }
}

//best solution from gpt
class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if the lengths are equal, if not, return false
        if (s.length() != goal.length()) {
            return false;
        }

        // Create a doubled version of s
        String doubledS = s + s;

        // Check if goal is a substring of the doubled string
        return doubledS.contains(goal);
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotateString("abcde", "cdeab")); // Output: true
        System.out.println(solution.rotateString("abcde", "abced")); // Output: false
    }
}
