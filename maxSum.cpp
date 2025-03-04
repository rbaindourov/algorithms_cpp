// //{ Driver Code Starts
#include <bits/stdc++.h>
#include <vector>
#include <algorithm>
#include <map>
#include <iostream>

using namespace std;

class Solution {
public:
    long long maxSum(vector<int>& arr) {
        // If the array size is <= 1, no sum can be formed
        if (arr.size() <= 1) {
            return 0;
        }

        // Sort the array
        sort(arr.begin(), arr.end());

        // To store the rearranged array
        vector<int> answer;
        int i = 0, j = arr.size() - 1;

        // Arrange smallest and largest alternately
        while (i <= j) {
            if (i == j) {
                // Push the last remaining element
                answer.push_back(arr[i]);
                break;
            }
            // Push smallest and largest alternately
            answer.push_back(arr[i]);
            answer.push_back(arr[j]);
            i++;
            j--;
        }

        // Compute the sum of absolute differences in the circular manner
        long long sum = 0;
        for (int k = 0; k < arr.size() - 1; k++) {
            sum += abs(answer[k] - answer[k + 1]);
        }

        // Add the difference between the first and last element
        sum += abs(answer[arr.size() - 1] - answer[0]);

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
