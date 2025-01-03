import java.util.HashMap;
import java.util.Map;


class PrefixSum {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int result = 0;
        int sum  = 0;
        for(int i = 0; i < nums.length; i++ ){
            sum+=nums[i];
            int remainder =  (sum % k);
            if( remainder < 0 ) remainder += k;
            result += map.getOrDefault( remainder, 0 );
            map.put(remainder, map.getOrDefault(remainder,0) +1 );                
           
        }

        return result;
    }

    //generate main
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        PrefixSum obj = new PrefixSum();
        int result = obj.subarraysDivByK(nums, k);
        System.out.println(result);
    }
}