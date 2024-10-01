
//
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> unique = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for( int n : nums1 ){
            unique.add(n);
        }

        for( int n : nums2 ){
            if( unique.contains(n) ) {
                result.add(n);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}



/*
 * 
 * Given two integer arrays nums1 and nums2, return an array of their 
intersection
. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

* 
* */

//best
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         boolean[] map = new boolean[1001];
      int[] result = new int[1001];
      int count = 0 ;
      for(int num:nums1){
        map[num]=true;

      }
      for(int num:nums2){
        if(map[num]){
            result[count++]=num;
            map[num]= false;
                }
      }
      return Arrays.copyOfRange(result,0,count);
    }
}
