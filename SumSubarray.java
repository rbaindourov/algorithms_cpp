import java.util.HashMap;
import java.util.Map;

class SumSubarray {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int result = 0;
        int sum  = 0;
        for(int i = 0; i < nums.length; i++ ){
            sum+= nums[i];
            int dif =  sum - k;
            result += map.getOrDefault( dif, 0 );
            map.put(sum, map.getOrDefault(sum,0) +1 );                
           
        }

        return result;

    }

    //generate main
    public static void main(String[] args) {
        int[] nums = {1,-1,1,1,1};
        int k = 2;
        SumSubarray obj = new SumSubarray();
        int result = obj.subarraySum(nums, k);
        System.out.println(result);
    }
}