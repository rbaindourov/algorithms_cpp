class MyAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, result = 0, i = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break;

            // Handle overflow/underflow
            if (result > (Integer.MAX_VALUE - (c - '0')) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (c - '0');
        }

        return result * sign;
    }

    public static void main(String[] args) {
        MyAtoi converter = new MyAtoi();
        
        // Test cases
        System.out.println(converter.myAtoi("42"));            // Output: 42
        System.out.println(converter.myAtoi("   -42"));        // Output: -42
        System.out.println(converter.myAtoi("4193 with words")); // Output: 4193
        System.out.println(converter.myAtoi("words and 987")); // Output: 0
        System.out.println(converter.myAtoi("-91283472332"));   // Output: -2147483648 (Integer.MIN_VALUE)
    }
}