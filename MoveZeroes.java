class MoveZeroes {
    // public void moveZeroes(int[] nums) {
    //     int i = 0;
    //     int j = nums.length -1;
    //     while( i < nums.length ){
    //         if( nums[i] == 0 ){
    //             while( j> 0 && nums[j] == 0 ) j--;
    //             nums[i] = nums[j];
    //             nums[j] = 0;
    //             j--;
    //         }
    //         i++;
    //     }


    // }

    public void moveZeroes(int[] nums) {
        int index = 0;  // Keeps track of where to place the non-zero elements
        
        // Traverse through the array and move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        
        // Fill the rest of the array with zeroes
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
   
    //generate main
    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        obj.moveZeroes(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

}