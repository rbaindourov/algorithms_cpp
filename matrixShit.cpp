#include <iostream>
#include <vector>

using namespace std;

void setZeroes(vector<vector<int>>& mat) {
    int n = mat.size();
    int m = mat[0].size();

    bool firstRowHasZero = false;
    bool firstColHasZero = false;

    // Check if the first row has any zero
    for (int j = 0; j < m; j++) {
        if (mat[0][j] == 0) {
            firstRowHasZero = true;
            break;
        }
    }

    // Check if the first column has any zero
    for (int i = 0; i < n; i++) {
        if (mat[i][0] == 0) {
            firstColHasZero = true;
            break;
        }
    }

    // Use the first row and column to mark zeros
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (mat[i][j] == 0) {
                mat[i][0] = 0;
                mat[0][j] = 0;
            }
        }
    }

    // Update the matrix based on the markers
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (mat[i][0] == 0 || mat[0][j] == 0) {
                mat[i][j] = 0;
            }
        }
    }

    // Update the first row if needed
    if (firstRowHasZero) {
        for (int j = 0; j < m; j++) {
            mat[0][j] = 0;
        }
    }

    // Update the first column if needed
    if (firstColHasZero) {
        for (int i = 0; i < n; i++) {
            mat[i][0] = 0;
        }
    }
}

int main() {
    vector<vector<int>> mat = {
        {0, 1, 2, 0},
        {3, 4, 5, 2},
        {1, 3, 1, 5}
    };

    setZeroes(mat);

    for (const auto& row : mat) {
        for (int elem : row) {
            cout << elem << " ";
        }
        cout << endl;
    }

    return 0;
}
//
// Created by robert on 12/24/24.
//
