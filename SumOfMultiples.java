class Solution {
    public int sumOfMultiples(int n) {
        return sumDivisibleBy(3, n) + sumDivisibleBy(5, n) + sumDivisibleBy(7, n) 
               - sumDivisibleBy(15, n) - sumDivisibleBy(21, n) - sumDivisibleBy(35, n) 
               + sumDivisibleBy(105, n);
    }
    
    private int sumDivisibleBy(int k, int n) {
        int p = n / k; // Largest integer such that k * p <= n
        return k * p * (p + 1) / 2; // Sum of the first p multiples of k
    }
}
