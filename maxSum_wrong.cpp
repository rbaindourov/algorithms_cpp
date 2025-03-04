// //{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long maxSum(vector<int>& arr) {
         // code here
         if( arr.size() <=1 ){
             return 0;
         }

         sort( arr.begin(), arr.end() );

         vector<int> answer;
         int i =0, j = arr.size() -1;
         while( i <= j ){
             if( i == j ){
                 answer.push_back(i);
                 break;
             }
             answer.push_back( arr[i] );
             answer.push_back( arr[j] );
             i++;
             j--;
         }


         int sum = 0;
         for( int k = 0; k < arr.size()-1; k++){
             sum +=abs(answer[k]-answer[k+1]);
         }
         sum+=abs(answer[arr.size()-1]-answer[0]);
         return sum;
    }
};


int main() {

        Solution ob;
        vector<int> arr = {
            11245, 18848, 2301, 12214, 17037, 5292, 24406, 22904, 17701, 31384, 7359, 10997, 11713, 15049, 14937, 21216,
            25115, 3749, 3142, 5084, 7453, 31999, 5973, 21391, 4514, 470, 27105, 8184, 10877, 24128, 31734, 7939, 3004,
            9377, 23222, 7259, 14638, 21792, 8955, 10624, 1570, 7772, 3902, 1049, 12914, 5722, 7352
        };
        long long ans = ob.maxSum(arr);
        cout << ans << endl;
        cout << "~" << endl;

    return 0;
}
