class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> lookup = new HashMap<>();
        for( int i = 0; i < nums.length; i++ ){
            int complement = target - nums[i];
            if( lookup.containsKey(complement))
                return new int[] { lookup.get(complement), i };
            else
                lookup.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Solution");
    }
}