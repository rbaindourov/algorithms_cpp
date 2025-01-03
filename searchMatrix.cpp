//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
public:


    // Function to search a given number in row-column sorted matrix.
    bool searchMatrix(vector<vector<int>> &mat, int x) {
        // code here
        vector<int>*row = nullptr;
        int rows = mat.size();
        int cols = mat[0].size();

        for( int i = 0; i < rows; i++ ){
            if( mat[i][0] <= x && mat[i][cols-1] >= x ){
                row = &(mat[i]);
                break;
            }
        }

        if( row == nullptr ) return false;

        auto binarySearch = [row, x]( int low, int high ) -> bool{

            while( low <= high ){
                int mid = low + (high-low)/2;

                if( (*row)[mid] == x ){
                    return true;
                }else if((*row)[mid] < x ){
                    low =  mid + 1;
                } else {
                    high = mid - 1;
                }

            }

            return false;

        };

        return binarySearch(0, cols -1 );
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {

        int n, m;
        cin >> n >> m;
        vector<vector<int> > matrix(n);

        for (int i = 0; i < n; i++) {
            matrix[i].assign(m, 0);
            for (int j = 0; j < m; j++) {
                cin >> matrix[i][j];
            }
        }

        int x;
        cin >> x;
        Solution obj;
        if (obj.searchMatrix(matrix, x))
            cout << "true\n";
        else
            cout << "false\n";

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends