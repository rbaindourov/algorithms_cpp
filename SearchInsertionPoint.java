public class SearchInsertionPoint {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }   
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }       
    public static void main(String[] args) {
        SearchInsertionPoint sol = new SearchInsertionPoint();
        int[] nums = {1,3,5,6,7,8,9,10,11,12,13};
        int target = 5;
        System.out.println(sol.searchInsert(nums, target)); // 2
    }
}
