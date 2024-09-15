import java.util.*;

class Solution {
    public static void main(String[] args) {
        String text = "Cosmo,is,an,incredible,technical,companion,with,very,strong,skills,in,Algorithms,and,Data,Structures,and,a,great,teacher,for,technical,interviews.";
        String[] words = text.split(",");
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        for( String word : words){
            wordCount.computeIfAbsent(word, (k) -> 1);
            wordCount.computeIfPresent(word, (k, v) -> v + 1);
        }
        System.out.println(wordCount);
    }
}