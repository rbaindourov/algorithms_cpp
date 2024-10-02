//best solution using quadratic formula
class Solution {
    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}


//My solution
class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        int difference = n;
        while( difference > 0 ){
            count++;
            difference = difference - count;
        }
        
        if( difference < 0 ) count--;
        return count;
    }
}