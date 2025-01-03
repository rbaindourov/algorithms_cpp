class FindPositive {

  private static int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid - 1;  // Try to find an earlier positive number
            } else {
                left = mid + 1;   // Move to the right side
            }
        }
        return left;  // 'left' will be at the first positive number
    }

    public static void main(String[] args) {
        int[] pos = {-3,-2,-1,0,0,1,2,3};
        System.out.println(findFirstPositive(pos));
    }
}