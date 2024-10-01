class Solution {
    public int missingNumber(int[] nums) {
        int n =  nums.length;
        boolean[] range = new boolean[n+1];
        for( int i : nums ){
            range[i]=true;
        }
        int result=0;
        for( int i = 0; i <= n; ++i )
            if(!range[i]){
                result = i;
                break;
            }


        return result;
    }
}


    class Solution {
      public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // carl gauss as a child 
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
     }
    }
