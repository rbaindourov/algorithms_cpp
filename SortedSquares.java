import java.util.Arrays;

public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        // Create a result array of the same size as nums
        int[] result = new int[nums.length];
        
        // Initialize two pointers, one at the beginning and one at the end
        int left = 0;
        int right = nums.length - 1;
        
        // Start filling the result array from the last position
        int index = nums.length - 1;
        
        // Compare squares of elements at the left and right pointers
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;  // Move to the next position in the result array
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Example 1:
        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums1))); // Output: [0, 1, 9, 16, 100]

        // Example 2:
        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums2))); // Output: [4, 9, 9, 49, 121]
    }
}
