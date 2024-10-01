class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        if(nums.length == 0)   
            return res;

        if(nums.length == 1){
            res.add(nums[0]);
            return res;
        }

        int num1 = nums[0], num2 = nums[1], c1 = 0, c2 = 0;

        int count = nums.length/3;

        for(int val : nums){

            if(num1 == val)
                c1 ++;

            else if(num2 == val)
                c2 ++;

            else if(c2 == 0){
                num2 = val;
                c2 = 1;
            }

            else if(c1 == 0){
                num1 = val;
                c1 = 1;
            }

            else{
                c1 --;
                c2 --;
            }
        }

        c1 = 0; c2 = 0;

        for(int val : nums){
            if(num1 == val)
                c1 ++;
            else if(num2 == val)
                c2 ++;
        }

        if(c1 > count) 
            res.add(num1);

        if(c2 > count && num1 != num2) 
            res.add(num2);

        return res;
    }
}



public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        partition(nums, 0, nums.length - 1, res);
        return res;
    }

    void partition(int[] nums, int left, int right, List<Integer> res) {
        int threshold = nums.length / 3;

        if (right - left + 1 <= threshold) {
            return;
        }

        // Choose a pivot (we'll just take the rightmost element)
        int pivot = nums[right];
        int midBegin = left, i = left, j = right;

        // Partition the array into three parts
        while (i <= j) {
            if (nums[i] == pivot) {
                i++;
            } else if (nums[i] < pivot) {
                swap(nums, midBegin, i);
                i++;
                midBegin++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }

        // Count how many times the pivot element occurs in the entire array
        int pivotCount = 0;
        for (int num : nums) {
            if (num == pivot) {
                pivotCount++;
            }
        }

        // If the pivot element occurs more than n/3 times, add it to the result list
        if (pivotCount > threshold && !res.contains(pivot)) {
            res.add(pivot);
        }

        // Recursively process the left and right partitions
        partition(nums, left, midBegin - 1, res);
        partition(nums, j + 1, right, res);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;

        for( int num : nums ){
            count.computeIfPresent(num, (key, val) -> ++val );
            count.computeIfAbsent(num, key -> 1);
        }
        for( Map.Entry<Integer, Integer> set: count.entrySet()  ){
            if(set.getValue() > threshold )
                result.add(set.getKey());
        }

        return result;
    }
}
