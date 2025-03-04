import java.util.Arrays;

public class FindMatrixDifference {

    public static int findMaxDifference(int[][] mat) {
        int N = mat.length;

        if (N <= 1) {
            return -1; // Not enough elements for a valid comparison
        }

        // Create a 2D array to store the maximum value for each cell
        int[][] maxValue = new int[N][N];

        // Initialize the maxValue array with the minimum integer value
        for (int[] row : maxValue) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        // Initialize the last row and last column of maxValue
        maxValue[N - 1][N - 1] = mat[N - 1][N - 1];
        for (int i = N - 2; i >= 0; i--) {
            maxValue[N - 1][i] = Math.max(mat[N - 1][i], maxValue[N - 1][i + 1]);
            maxValue[i][N - 1] = Math.max(mat[i][N - 1], maxValue[i + 1][N - 1]);
        }

        // Fill in the maxValue array using dynamic programming
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 2; j >= 0; j--) {
                maxValue[i][j] = Math.max(mat[i][j], Math.max(maxValue[i + 1][j], maxValue[i][j + 1]));
            }
        }

        // Find the maximum difference for each pair of indices (c, d) and (a, b)
        int maxDiff = Integer.MIN_VALUE;
        for (int c = 0; c < N - 1; c++) {
            for (int d = 0; d < N - 1; d++) {
                maxDiff = Math.max(maxDiff, maxValue[c + 1][d + 1] - mat[c][d]);
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        // Example matrix
        int[][] mat = {
            { 1, 2, -1, -4, -20 },
            { -8, -3, 4, 2, 1 },
            { 3, 8, 6, 1, 3 },
            { -4, -1, 1, 7, -6 },
            { 0, -4, 10, -5, 1 }
        };

        // Output the maximum difference
        System.out.println("The maximum difference is: " + findMaxDifference(mat)); // Expected Output: 18
    }
}
