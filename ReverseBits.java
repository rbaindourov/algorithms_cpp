public class ReverseBits {
    // Function to reverse bits of a 32-bit unsigned integer
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Left shift result to make room for the next bit
            result <<= 1;
            // Add the least significant bit of n to the result
            result |= (n & 1);
            // Right shift n to get the next bit
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        // Test case 1
        int n1 = 0b00000010100101000001111010011100;
        System.out.println(solution.reverseBits(n1)); // Output: 964176192

        // Test case 2
        int n2 = 0b11111111111111111111111111111101;
        System.out.println(solution.reverseBits(n2)); // Output: 3221225471
    }
}
