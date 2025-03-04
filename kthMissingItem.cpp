
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int kthMissing(vector<int>& arr, int k) {
        int current = 1;
        int n = arr.size();
        vector<int> missing;
        
        for(int i = 0; i < n; i++) {
            int diff = arr[i] - current;
            if( diff > 0) {
                for(int j = current; j < diff + current; j++) {
                    cout << j << endl;
                    missing.push_back(j);    
                }
            }
            current = arr[i] + 1;    
        }
        
        return missing[k];
    }
};

int main() {
    Solution solution;
    vector<int> arr = {2, 3, 4, 7, 11};
    int k = 5;
    
    int result = solution.kthMissing(arr, k);
    cout << "The " << k << "th missing positive integer is: " << result << endl;
    
    return 0;
}