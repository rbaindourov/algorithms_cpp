class Solution {
    public String reverseWords(String s) {
        char[] str  = s.toCharArray();
        int start =0;
        int n = str.length;
        for(int end =0;end<n;end++)
        {
            if(str[end]==' ')
            {
                reverse(str,start,end-1);
                start = end+1;
            }
        }
         reverse(str,start,n-1);
        String ss = new String(str);
        return ss;
    }
    public static void reverse(char[] str,int low,int high)
    {
        while(low<=high)
        {
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            
            low++;
            high--;
        }
    }
}


class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for( String word:words){
            char[] c = word.toCharArray();
            rev(0, c.length-1, c );
            result.append(c);
            result.append(" ");
        }

        return result.toString().trim();        
    }


    public void rev(int i,int j,char[] str){
        while(i<j){
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;
        }
    }
}
