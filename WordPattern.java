import java.util.HashMap;
import java.util.Map;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mp =  new HashMap<>();
        Map<String, Character> mp2 =  new HashMap<>();


        String[] words = s.split(" ");

        if( pattern.length() != words.length ) return false;

        int index = 0;
        for(char c : pattern.toCharArray() ){
            if(mp.containsKey(c) && !mp.get(c).equals(words[index]) ) return false;
            else mp.put(c, words[index]);

            if(mp2.containsKey(words[index]) && mp2.get(words[index]) != c ) return false;
            else mp2.put( words[index], c);


            index++;
        }

        return true;

    }


    public boolean wordPattern2(String pattern, String s) {

        HashMap<Character, String> hm=new HashMap<>();

        String[] str=s.split(" ");

        if(pattern.length()!=str.length){
            return false;
        }

        for(int i=0; i<str.length; i++){
            char ch=pattern.charAt(i);
            if(hm.containsKey(ch)){
                    if(!hm.get(ch).equals(str[i])){
                        return false;
                    }
            }
            else{
                if(hm.containsValue(str[i])){
                    return false;
                }
                hm.put(ch,str[i]);
            }
        }
        return true;

        
    

    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
    }


}