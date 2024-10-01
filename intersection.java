/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

*/

//chatgpt
import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap1 = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        
        // Count the frequency of each number in nums1
        for (int num : nums1) {
            countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
        }
        
        // Iterate through nums2, and if the number exists in nums1, add it to the result
        for (int num : nums2) {
            if (countMap1.containsKey(num) && countMap1.get(num) > 0) {
                intersection.add(num);
                countMap1.put(num, countMap1.get(num) - 1); // Reduce the count in the map
            }
        }
        
        // Convert the list to an array
        return intersection.stream().mapToInt(i -> i).toArray();
    }
}


//best
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] c=new int[1001];
        for(int i=0;i<nums1.length;i++){
            c[nums1[i]]++;
        }
        int k=0;
        int[] ans=new int[nums2.length];
        for(int i=0;i<nums2.length;i++){
            if(c[nums2[i]]>0){
                ans[k]=nums2[i];
                c[nums2[i]]--;
                k++;
            }
        }
        return Arrays.copyOfRange(ans,0,k);
    }
}
