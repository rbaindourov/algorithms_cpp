class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        for (int i = 0; i<nums.length; i++) {
            map[nums[i]]++;
        }
        int s = 0;
        for (int i = 0; i<101; i++) 
            s+= map[i]*(map[i]-1)/2;
        return s;
    }
}


class Solution {
    public int numIdenticalPairs(int[] nums) {
            int count = 0;
            for( int i = 0; i < nums.length; i=i+1 ){
                for( int j=i+1; j < nums.length; j=j+1){
                    if( nums[i] == nums[j] ) {
                        count++;
                    }
                }
            }

        return count;
    }
}
