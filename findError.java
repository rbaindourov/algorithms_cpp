class Solution {
    public int[] findErrorNums(int[] nums) {
        int i =0;
        while( i < nums.length ){
            if( nums[i] != i+1 )
                break;
            i++;
        }


        return new int[] {nums[i], i+1};
        
    }


    
}
