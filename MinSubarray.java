import java.util.*;


class MinSubaray {
    public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Initialize with 0 remainder at index -1 to handle edge cases.

        long sum = 0;
        int remainder = 0;

        // Calculate the total sum of the array.
        for (int num : nums) {
            sum += num;
        }

        remainder = (int) (sum % p);  // We care only about the remainder when sum is divided by p.

        // If the sum is already divisible by p, no need to remove any subarray.
        if (remainder == 0) return 0;

        int res = nums.length;  // Initialize the result to the maximum possible length.
        int cur_sum = 0;

        // Iterate through the array to find the smallest subarray to remove.
        for (int i = 0; i < nums.length; i++) {
            cur_sum = (cur_sum + nums[i]) % p;  // Current prefix sum modulo p.
            int prefix = (cur_sum - remainder + p) % p;  // Calculate what we're looking for.

            // If this prefix remainder has been seen before, calculate subarray length.
            if (map.containsKey(prefix)) {
                int length = i - map.get(prefix);  // Subarray length.
                res = Math.min(res, length);  // Update result with minimum length.
            }

            // Store the current remainder and index.
            map.put(cur_sum, i);
        }

        // If the result is still equal to the length of the array, no valid subarray was found.
        return (res == nums.length) ? -1 : res;
    }


    public static void main(String[] args) {
        MinSubaray minSubaray = new MinSubaray();
        int[] nums = {3,1,4,2};
        int p = 6;
        System.out.println(minSubaray.minSubarray(nums, p));
    }
}
