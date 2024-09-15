public class DivideTwoIntegers {
    
        public int divide(int dividend, int divisor) {
            // Edge case: handle overflow for the specific case
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE; // Overflow case
            }
            
            // Determine the sign of the result
            boolean negative = (dividend < 0) ^ (divisor < 0);
            
            // Work with absolute values
            long absDividend = Math.abs((long) dividend);
            long absDivisor = Math.abs((long) divisor);
            
            // Result variable
            long quotient = 0;
            
            // Perform the division using bitwise shifts
            while (absDividend >= absDivisor) {
                long tempDivisor = absDivisor;
                long multiple = 1;
                
                // Increase the divisor by powers of two until it exceeds the dividend
                while (absDividend >= (tempDivisor << 1)) {
                    tempDivisor <<= 1;
                    multiple <<= 1;
                }
                
                // Subtract and add to the quotient
                absDividend -= tempDivisor;
                quotient += multiple;
            }
            
            // Apply the sign of the result
            if (negative) {
                quotient = -quotient;
            }
            
            // Return the result within the 32-bit signed integer range
            return (int) quotient;
        }
    
      
    
    
    public static void main(String[] args) {
        DivideTwoIntegers divider = new DivideTwoIntegers();
        
        // Test values
        System.out.println(divider.divide(-2147483648, -1));  // Output: 3
        System.out.println(divider.divide(1, -1)); // Output: -3
        System.out.println(divider.divide(10, -3)); // Output: -3
        System.out.println(divider.divide(0, 1));   // Output: 0
        System.out.println(divider.divide(1, 1));   // Output: 1
        System.out.println(divider.divide(1, 2));   // Output: 0
    }
}