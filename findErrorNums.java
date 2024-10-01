// me! 
class Solution {
       public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] range = new boolean[n+1];
        int[] answer={0,0};
        int sum=0;
        int expectedSum = n * (n + 1) / 2; // carl gauss as a child 

        for( int i : nums ){
            if(range[i]) {
                answer[0] = i;
            } else 
                sum += i;

            range[i]=true;   
        }

        answer[1] = expectedSum - sum ;
        return answer;

    }   
}


//best

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] range = new boolean[n+1];
        int[] res={0,0};
        
        for( int i : nums ){
            if(range[i]) res[0]= i;
            range[i]=true;   
        }

        for( int i = 1; i <= n; i++){
            if(!range[i]){
                res[1]=i;
                break;
            }
        }

        return res;

    }
    
}





//chatgpt
import java.util.HashSet;

class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int duplicate = -1;
        int n = nums.length;

        // Identify the duplicate number
        for (int num : nums) {
            if (seen.contains(num)) {
                duplicate = num; // Found the duplicate
            } else {
                seen.add(num);
            }
        }

        // Identify the missing number
        int missing = -1;
        for (int i = 1; i <= n; i++) {
            if (!seen.contains(i)) {
                missing = i; // Found the missing number
                break;
            }
        }

        return new int[] {duplicate, missing};
    }
}

