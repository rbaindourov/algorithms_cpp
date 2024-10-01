class Solution {
    public String reformatDate(String date) {
        
        StringBuilder day = new StringBuilder();
        StringBuilder month = new StringBuilder();
        StringBuilder year = new StringBuilder();
        int count = 0;
        int start = 0;
        int end = 0;
        for( char c : date.toCharArray() ){
            if( c == ' '){
                count++;
                if( count == 1 ){
                    String temp =  date.substring(start,end-2);
                    if( temp.length() == 1)
                        day.append('0');
                    day.append(temp);
                } else
                    month.append(getMonth(date.substring(start,end))); 
                    
                start = end+1;
            }
            end++;
        }

        year.append( date.substring(start) );
        return new String(year.append('-').append(month).append('-').append(day));

    }


public static String getMonth(String m) {
    switch (m) {
        case "Jan":
            return "01";
        case "Feb":
            return "02";
        case "Mar":
            return "03";
        case "Apr":
            return "04";
        case "May":
            return "05";
        case "Jun":
            return "06";
        case "Jul":
            return "07";
        case "Aug":
            return "08";
        case "Sep":
            return "09";
        case "Oct":
            return "10";
        case "Nov":
            return "11";
        case "Dec":
            return "12";
        default:
            return "Invalid month"; // Handle invalid input
    }
}


    

}



class Solution {
    public String reformatDate(String date) {
         StringBuilder sb = new StringBuilder();
         sb.append(date.substring(date.length() - 4)).append("-");
         String m = date.length() == 13 ? date.substring(5, 8) : date.substring(4, 7);

         switch(m){
             case "Jan": sb.append("01-"); break;
             case "Feb": sb.append("02-"); break;
             case "Mar": sb.append("03-"); break;
             case "Apr": sb.append("04-"); break;
             case "May": sb.append("05-"); break;
             case "Jun": sb.append("06-"); break;
             case "Jul": sb.append("07-"); break;
             case "Aug": sb.append("08-"); break;
             case "Sep": sb.append("09-"); break;
             case "Oct": sb.append("10-"); break;
             case "Nov": sb.append("11-"); break;
             case "Dec": sb.append("12-"); break;
         }

         if(date.length() < 13){
           sb.append("0");
           sb.append(date.substring(0,1));
         }else{
           sb.append(date.substring(0,2));
         }

         return sb.toString();
    }
}
