
class Solution {
    boolean[] vowel = new boolean[26];
    public Solution(){
        for(char c: new char[]{'a', 'e', 'i', 'o','u'}){
            vowel[c-'a']=true;
        }
    }

    public int countVowelSubstrings(String word) {
        int res=0,start=0, n=word.length();
        for(int i=0; i<=n; i++){
            if(i==n||!vowel[word.charAt(i)-'a']){
                res+= count(word, start, i-1);
                start=i+1;
            }
        }
        return res;
    }
    
    int count(String s, int start, int end){
        if(end-start+1<5) return 0;
        int[] cnt=new int[26];
        int uc=0, res=0;
        for(int i=start; i<=end; i++){
            if(++cnt[s.charAt(i)-'a']==1) uc++;
            while(uc>=5){
                res+=end-i+1;
                if(--cnt[s.charAt(start++)-'a']==0) uc--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution obj = new Solution();
        String word = "aeiouu";
        int res = obj.countVowelSubstrings(word);
        System.out.println(res);
    }
}