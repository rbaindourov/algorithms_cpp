import java.util.*;

public class DifferentWaysToAddParentheses {
    
    // Main function to compute different ways to add parentheses
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        
        // Check for operators in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If the character is an operator, split the expression
            if (c == '+' || c == '-' || c == '*') {
                // Divide the expression into two parts
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                
                // Combine results from the left and right parts
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        // If the expression does not contain any operators, it is a single number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        return result;
    }

    // Testing the solution
    public static void main(String[] args) {
        DifferentWaysToAddParentheses obj = new DifferentWaysToAddParentheses();
        String expression = "2*3-4*5";
        List<Integer> result = obj.diffWaysToCompute(expression);
        System.out.println(result);
    }
}
