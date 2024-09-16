class RemoveTrailingZero {
    public static String removeTrailingZeros(String num) {
        int occurrence = 0; 
        for( int j = num.length()-1; j > 0; j-- ) {
            if( num.charAt(j) == '0' )
                occurrence = j;
            else
                break;
        }

        return num.substring(0, occurrence );
    }

    public static void main(String[] args) {
        System.out.println(removeTrailingZeros("51230100"));
    }
}