import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfDistances {

    
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] answer = new long[nums.length];
        Map<Integer, List<Integer>> numMap = new HashMap<>();

        for( int i = 0; i < n; i++ ){
            numMap.computeIfAbsent( nums[i], k -> new ArrayList<>() ).add(i);
        }

        for( List<Integer> indices: numMap.values() ){
            int size =  indices.size();

            long prefixSum = 0;
            for( int i = 0; i < size; i ++  ){
                int index = indices.get(i);
                answer[index] += (long) index * i - prefixSum;
                prefixSum += index;
            }

            long suffixSum = 0;
            for(int i = size -1; i >= 0; i-- ){
                int index = indices.get(i);
                answer[index] += suffixSum - (long) index * (size - i -1);
                suffixSum += index;
            }



        }
        
        return answer;

    }



    public static void main(String[] args) {
        SumOfDistances obj = new SumOfDistances();
        int[] nums = {1,3,1,5,4,3}; 
        long[] answer = obj.distance(nums);
        for(long i : answer){
            System.out.println(i);
        }
    }

}

