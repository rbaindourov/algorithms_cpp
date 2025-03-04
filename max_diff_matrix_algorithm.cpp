#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int findMaxValue(vector<vector<int>>& mat, int n) {
    // Create an auxiliary matrix to store maximum elements
    vector<vector<int>> max_matrix(n, vector<int>(n, 0));

    // Initialize variables
    int max_diff = INT_MIN;

    // Initialize the last value of max_matrix (bottom-right corner)
    max_matrix[n - 1][n - 1] = mat[n - 1][n - 1];

    // Precompute max values for the last row
    for (int j = n - 2; j >= 0; j--) {
        max_matrix[n - 1][j] = max(mat[n - 1][j], max_matrix[n - 1][j + 1]);
    }

    // Precompute max values for the last column
    for (int i = n - 2; i >= 0; i--) {
        max_matrix[i][n - 1] = max(mat[i][n - 1], max_matrix[i + 1][n - 1]);
    }

    // Precompute the rest of the max_matrix and find the maximum difference
    for (int i = n - 2; i >= 0; i--) {
        for (int j = n - 2; j >= 0; j--) {
            // Update the maximum difference
            max_diff = max(max_diff, max_matrix[i + 1][j + 1] - mat[i][j]);

            // Update the max_matrix for position (i, j)
            max_matrix[i][j] = max(mat[i][j], max(max_matrix[i + 1][j], max_matrix[i][j + 1]));
        }
    }

    return max_diff;
}

int main() {
    vector<vector<int>> mat =  {{ 1, 2, -1, -4, -20 },
             { -8, -3, 4, 2, 1 },
             { 3, 8, 6, 1, 3 },
             { -4, -1, 1, 7, -6 },
             { 0, -4, 10, -5, 1 }};
    int n = mat.size();

    cout << "Maximum Difference: " << findMaxValue(mat, n) << endl;

    return 0;
}