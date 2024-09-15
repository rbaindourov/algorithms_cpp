import java.util.*; // Add this import if you plan to use collections or other utilities

public class BinarySearch {
    
        public static void main(String[] args) {
           int[] nums = new int[] {4, 3, 2, 1, 7, 6, 5};
           System.out.println(findMax(nums));  // Output: 7
           
           int[] nums2 = new int[] {3, 2, 1};
           System.out.println(findMax(nums2));  // Output: 3
           
           int[] nums3 = new int[] {6, 5, 4, 3, 2, 1, 7};
           System.out.println(findMax(nums3));  // Output: 7
        }
    
        public static int findMax(int[] nums) {
            int left = 0, right = nums.length - 1;
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                
                if (nums[mid] > nums[right]) {
                    // Mid element is greater than the rightmost element, max is in the right half
                    left = mid;
                } else {
                    // Mid element is less than or equal to the rightmost element, max is in the left half
                    right = mid - 1;
                }
            }
            
            // At the end of the loop, left == right, which will point to the maximum element
            return nums[left];
        }
    }


