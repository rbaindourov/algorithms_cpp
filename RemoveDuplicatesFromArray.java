public class RemoveDuplicatesFromArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromArray sol = new RemoveDuplicatesFromArray();
        int[] nums = {1, 1, 2};
        System.out.println(sol.removeDuplicates(nums)); // 2
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(sol.removeDuplicates(nums2)); // 5   
        
        
    }
}
