// class Solution {
// public:
//     string convert(string s, int numRows) {
        
//         if( numRows == 1 ) return s;

//         int direction = -1;
//         vector<vector<char>> result(numRows);

//         int current = 0;
//         for( char c : s ) {
//             result[current].emplace_back(c);                
//             if( current % (numRows-1) == 0 ) direction = -direction;
//             current += direction;
//         }        

//         string combined;
//         for( const auto & vec:result)
//             combined.insert(combined.end(), vec.begin(),vec.end());

//         return combined;
        
//     }
// };


#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        int n = s.size();
        if (n == 1 || numRows < 2 || n <= numRows) return s;
        
        string ans;
        
        for (int i = 0; i < numRows; i++) {
            int j = i;
            ans.push_back(s[i]); // First character of the row
            int down = 2 * (numRows - 1 - i); // Downward step size
            int up = 2 * i; // Upward step size
            
            if (up == 0 && down == 0) return s;
            
            while (j < n) {
                j += down;
                if (j < n && down > 0) ans.push_back(s[j]);
                
                j += up;
                if (j < n && up > 0) ans.push_back(s[j]);
            }
        }
        
        return ans;
    }
};

int main() {
    Solution solution;
    string s = "PAYPALISHIRING"; // Example input
    int numRows = 3; // Example row count
    
    string result = solution.convert(s, numRows);
    
    cout << "Zigzag Conversion: " << result << endl; // Output the result
    
    return 0;
}

/*
numRows = 3;

P   A   H   N
A P L S I I G
Y   I   R

*/