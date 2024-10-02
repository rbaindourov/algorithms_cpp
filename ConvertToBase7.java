
//fastest solution
class Solution {
    public String convertToBase7(int num) {
        return Integer.toString(num,7);
    }
}

// my solution
class Solution {
    public String convertToBase7(int num) {
        StringBuilder result = new StringBuilder();

        if( num == 0 ) return "0";

        if( num < 0 ){
            return "-" + convertToBase7(-num);
        }
        while(num > 0){
            result.append( num % 7);
            num = num /7;
        }
        return result.reverse().toString();
        
    }
}