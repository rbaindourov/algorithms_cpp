class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] range = new boolean[nums.length];
        int result=0;
        for( int i : nums ){
            if(range[i]) {
                result = i;
                break;
            }
            range[i]=true;
        }
    
        return result;
    }
}
