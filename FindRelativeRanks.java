class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result =  new String[n];
        Integer[] index =  new Integer[n];
        
        for(int i = 0; i < n; i++){
            index[i] = i;
        }

        Arrays.sort( index, (a, b) -> score[b] - score[a]);

        for( int i = 0; i < n; i++){
            if( i == 0 ){
                result[index[i]] = "Gold Medal";
            } else if( i == 1 ){
                result[index[i]] = "Silver Medal";
            } else if( i == 2 ){
                result[index[i]] = "Bronze Medal";
            } else {
                result[index[i]] = String.valueOf( i+1 );

            }

        }

        return result;
        
    } 
}


/*
 * best solution
 * 
 *  
 class Solution {
    public String[] findRelativeRanks(int[] score) {
         int n = score.length;
        
        int maxScore = 0;
        for (int i = 0 ; i < n ; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }
        
        int[]  score2Index = new int[maxScore+1];
        
        for (int i = 0 ; i < n ; i++) {
            score2Index[score[i]] = i+1;
        }
        
        String[] ans = new String[n];
        
        int place = 1;
        
        for (int i = maxScore ; i >= 0 ; i--) {
            
            if (score2Index[i] == 0) continue;
                
            int actualIndex = score2Index[i]-1;
            if (place == 1) {
                ans[actualIndex] = "Gold Medal";
            } else if (place == 2) {
                ans[actualIndex] = "Silver Medal";
            } else if (place == 3) {
                ans[actualIndex] = "Bronze Medal";
            } else {
                ans[actualIndex] = String.valueOf(place);
            }
            place++; 
        }
        
        return ans;
    }
}
 */