class DivideTwoIntegers {
    divide(dividend, divisor) {
        // Handle overflow case
        if (dividend === -2147483648 && divisor === -1) {
            return 2147483647; // Return 231 - 1
        }

        // Determine the sign of the result
        const negative = (dividend < 0) !== (divisor < 0);
        
        // Work with absolute values
        let absDividend = Math.abs(dividend);
        let absDivisor = Math.abs(divisor);
        let quotient = 0;

        // Use bit manipulation to optimize the division
        for (let i = 31; i >= 0; i--) {
            // Check if the divisor shifted left by i is less than or equal to the dividend
            if ((absDivisor << i) <= absDividend) {
                absDividend -= (absDivisor << i); // Subtract the shifted divisor from dividend
                quotient += (1 << i); // Add the corresponding power of two to the quotient
            }
        }

        // Apply the sign to the quotient
        return negative ? -quotient : quotient;
    }

    static main() {
        const divider = new DivideTwoIntegers();
        
        // Test cases
        console.log(divider.divide(10, 3));              // Output: 3
        console.log(divider.divide(7, -3));              // Output: -2
        console.log(divider.divide(-2147483648, -1));   // Output: 2147483647
        console.log(divider.divide(0, 1));               // Output: 0
        console.log(divider.divide(1, 1));               // Output: 1
        console.log(divider.divide(1, 2));               // Output: 0
    }
}

// Call the main method to run tests
DivideTwoIntegers.main();