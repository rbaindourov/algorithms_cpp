import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                int prevIndex = indexMap.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            indexMap.put(nums[i], i);
        }
        
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        
        // Example 1
        int[] nums1 = {1, 2, 3, 4, 5, 1, 1};
        int k1 = 3;
        System.out.println(solution.containsNearbyDuplicate(nums1, k1));  // Output: true

        // Example 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(solution.containsNearbyDuplicate(nums2, k2));  // Output: true

        // Example 3
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(solution.containsNearbyDuplicate(nums3, k3));  // Output: false
    }
}
