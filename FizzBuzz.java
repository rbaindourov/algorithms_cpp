//best
class Solution {
    public List<String> fizzBuzz(int n) {
        return new java.util.AbstractList<String>() {
            @Override
            public String get(int index) {
                index++;
                return
                        index % 3 == 0 && index % 5 == 0 ?
                                "FizzBuzz" :
                                index % 3 == 0 ? "Fizz" :
                                        index % 5 == 0 ? "Buzz" :
                                                String.valueOf(index);
            }

            @Override
            public int size() {
                return n;
            }
        };
    }
}


//gpt

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");

            if (sb.length() == 0) {
                result.add(String.valueOf(i));  // No Fizz or Buzz, add the number
            } else {
                result.add(sb.toString());  // Add the concatenated Fizz/Buzz/FizzBuzz
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(15));
    }
}


