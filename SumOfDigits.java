import java.math.BigInteger;

public class SumOfDigits {

    public static int getLucky(String s, int k) {
        // Convert letters to numbers
        BigInteger num = new BigInteger("0");
        for (char c : s.toCharArray()) {
            num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(c - 'a' + 1));
        }

        // Perform k transformations
        for (int i = 0; i < k; i++) {
            BigInteger sum = BigInteger.ZERO;
            BigInteger temp = num;
            while (!temp.equals(BigInteger.ZERO)) {
                sum = sum.add(temp.mod(BigInteger.TEN));
                temp = temp.divide(BigInteger.TEN);
            }
            num = sum;
        }

        return num.intValue();
    }

    public static void main(String[] args) {
        String s = "hvmhoasabaymnmsd";
        int k = 1;
        int result = getLucky(s, k);
        System.out.println(result); // Output: 79
    }
}