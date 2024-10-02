class NextGreaterElement {
    public int[] nextGreaterElement(int[] subset, int[] nums) {
        
        int top = -1;
        int[] stack = new int[1001];
        int[] map = new int[10001];

        for(int i = nums.length-1; i >= 0; i--){
            while(top >= 0 && stack[top] < nums[i]) top--;
            map[nums[i]] = top < 0 ? -1 : stack[top];
            stack[++top] = nums[i];
        }

        for(int i = subset.length-1; i >= 0; i--){
            subset[i] = map[subset[i]];
        }
        return subset;
    }

    //generate main
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        NextGreaterElement obj = new NextGreaterElement();
        int[] result = obj.nextGreaterElement(nums1, nums2);
        System.out.println(java.util.Arrays.toString(result));
    }
}


// brute force
/*
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] answer =  new int[nums1.length];
        Arrays.fill(answer, -1);
        for( int i = 0; i < nums1.length; i++ ){
            for( int j =0; j < nums2.length; j++ ){
                if(nums1[i] == nums2[j] && j < nums2.length-1){
                    int k = j+1;
                    while(k < nums2.length){
                        if( nums1[i] < nums2[k]){
                            answer[i] = nums2[k];
                            break;
                        }
                        k++;
                       
                    }
                }
            }

        }
        return answer;

    }
}
*/