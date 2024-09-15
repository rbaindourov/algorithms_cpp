/* Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters. */

class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {

        String maxPrefix = strs[0];

        for( int i = 1; i < strs.length; i++){

            String currentString = strs[i];

            for(int j = 0; j < maxPrefix.length(); j++){

                if(j >= currentString.length() || maxPrefix.charAt(j) != currentString.charAt(j)){

                    maxPrefix = maxPrefix.substring(0, j);
                    break;
                }
            }
            
        }

        return maxPrefix;

    }
}

