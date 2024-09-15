/* Companies
Hint
You are given an integer array nums of size n.

Consider a non-empty subarray from nums that has the maximum possible bitwise AND.

In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
Return the length of the longest such subarray.

The bitwise AND of an array is the bitwise AND of all the numbers in it.

A subarray is a contiguous sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3,3,2,2]
Output: 2
Explanation:
The maximum possible bitwise AND of a subarray is 3.
The longest subarray with that value is [3,3], so we return 2.
Example 2:

Input: nums = [1,2,3,4]
Output: 1
Explanation:
The maximum possible bitwise AND of a subarray is 4.
The longest subarray with that value is [4], so we return 1. */

public class LongestSubarrayWithMaxAnd {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 2, 2};
        System.out.println(longestSubarrayWithMaxAnd(nums1));  // Output: 2

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(longestSubarrayWithMaxAnd(nums2));  // Output: 1
    }

    public static int longestSubarrayWithMaxAnd(int[] nums) {
        int maxAnd = Integer.MIN_VALUE; // Step 1: Initialize maxAnd
        for (int num : nums) {
            maxAnd = Math.max(maxAnd, num); // Find the maximum value
        }

        int maxLength = 0;
        int currentLength = 0;

        for (int num : nums) { // Step 2: Iterate through the array
            if (num == maxAnd) {
                currentLength++; // Increment length if the number is maxAnd
                maxLength = Math.max(maxLength, currentLength); // Update maxLength
            } else {
                currentLength = 0; // Reset length if the number is not maxAnd
            }
        }

        return maxLength; // Return the maximum length found
    }
}