public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Indexes for the last elements in nums1, nums2, and the merged array
        int i = m - 1;  // Last valid element in nums1
        int j = n - 1;  // Last element in nums2
        int k = m + n - 1;  // Last position in nums1 where elements can be merged

        // Start merging from the end of nums1 and nums2
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        // Example 1:
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(java.util.Arrays.toString(nums1));  // Output: [1, 2, 2, 3, 5, 6]

        // Example 2:
        int[] nums1_2 = {1};
        int m_2 = 1;
        int[] nums2_2 = {};
        int n_2 = 0;
        merge(nums1_2, m_2, nums2_2, n_2);
        System.out.println(java.util.Arrays.toString(nums1_2));  // Output: [1]

        // Example 3:
        int[] nums1_3 = {0};
        int m_3 = 0;
        int[] nums2_3 = {1};
        int n_3 = 1;
        merge(nums1_3, m_3, nums2_3, n_3);
        System.out.println(java.util.Arrays.toString(nums1_3));  // Output: [1]
    }
}
