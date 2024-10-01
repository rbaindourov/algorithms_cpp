/* A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory. */

public class NextPermutationClass {
    public void nextPermutation(int[] nums) {
        // Find the first decreasing element from the end
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If the entire array is non-increasing, reverse it
        if (i >= 0) {
            // Find the element just larger than nums[i]
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap elements at i and j
            swap(nums, i, j);
        }
        
        // Reverse the elements from i + 1 to the end
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        NextPermutationClass np = new NextPermutationClass();

        // Test case 1
        int[] nums1 = {1, 2, 3};
        np.nextPermutation(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // Output: [1, 3, 2]

        // Test case 2
        int[] nums2 = {3, 2, 1};
        np.nextPermutation(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // Output: [1, 2, 3]

        // Test case 3
        int[] nums3 = {1, 1, 5};
        np.nextPermutation(nums3);
        System.out.println(java.util.Arrays.toString(nums3)); // Output: [1, 5, 1]

        // Test case 4
        int[] nums4 = {1, 3, 2};
        np.nextPermutation(nums4);
        System.out.println(java.util.Arrays.toString(nums4)); // Output: [2, 1, 3]

        // Test case 5
        int[] nums5 = {1, 2, 7, 5, 4, 3, 2};
        np.nextPermutation(nums5);
        System.out.println(java.util.Arrays.toString(nums5)); // Output: [1, 3, 2, 2, 4, 5, 7]
    }
}