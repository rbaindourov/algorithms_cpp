import javafx.util.Pair;

/*
 * 
 * Given an n x n matrix mat[n][n] of integers, find the maximum value of mat(c, d) – mat(a, b) over all choices of indexes such that both c > a and d > b.
 
Example: 
 
Input:
mat[N][N] = {{ 1, 2, -1, -4, -20 },
             { -8, -3, 4, 2, 1 },
             { 3, 8, 6, 1, 3 },
             { -4, -1, 1, 7, -6 },
             { 0, -4, 10, -5, 1 }};
 
Output: 18
The maximum value is 18 as mat[4][2]
- mat[1][0] = 18 has maximum difference.
 
The program should do only ONE traversal of the matrix. i.e. expected time complexity is O(n2)

A simple solution would be to apply Brute-Force. For all values mat(a, b) in the matrix, we find mat(c, d) that has maximum value such that c > a and d > b and keeps on updating maximum value found so far. We finally return the maximum value. 
 */

public class MatrixDifference {

    // Function to find the maximum difference mat(c, d) - mat(a, b)
    public static int findMaxDifference(int[][] mat) {
        int n = mat.length; // Size of the matrix
        int maxDiff = Integer.MIN_VALUE; // Variable to store the maximum difference
        int minValue = mat[n - 1][n - 1]; // Initialize minValue with the bottom-right element
        Pair<Integer, Integer> minPair = new Pair<>(n - 1, n - 1); // Initialize minPair with the bottom-right element

        // Traverse the matrix from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) { // Loop through rows in reverse
            for (int j = n - 1; j >= 0; j--) { // Loop through columns in reverse
                // For each mat[i][j], calculate the difference mat[i][j] - minValue
                if (i < n - 1 && j < n - 1) {
                    if( maxDiff < mat[i][j] - minValue) {
                        maxDiff = Math.max(maxDiff, mat[i][j] - minValue);
                        System.out.println(maxDiff + " = " + mat[i][j] + " - " + minValue + " at i:" + i + " j:" + j);
                    }
                }

                // Update minValue to be the minimum of the current element and the previous minValue
                if( mat[i][j] < minValue) {
                    minValue = mat[i][j];
                    minPair = new Pair<>(i, j);
                    System.out.println("minValue at " + minPair);
                }
                
                
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

        // Example output
        System.out.println("The maximum difference is: " + findMaxDifference(mat)); // Output: 18
    }
}
