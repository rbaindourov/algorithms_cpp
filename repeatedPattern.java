import java.util.*;

class Solution {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
		Set<String> seq = new HashSet<>();
		int len = s.length();
		if (len < 10 || len > 10000) return list;
		for (int i = 0; i <= len - 10; i++) {
			String pattern = s.substring(i, i + 10);
			if (!seq.add(pattern)) {
				if (!list.contains(pattern)) list.add(pattern);
			}
		}
		return list;
    }
    
    public static void main( String args[] ){
		System.out.println( findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCAAAAAGGGTTT") );
		
		
	}
}
