//
// Created by robert on 12/29/24.
//

#include "maxOfThreeSunarrays.h"
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> k_sums(n - k + 1, 0); // Store the sum of each k-length subarray
        vector<int> left(n - k + 1, 0);   // Best starting index from the left
        vector<int> right(n - k + 1, 0);  // Best starting index from the right
        vector<int> result(3, 0);

        // Compute the sums of all k-length subarrays
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k - 1) k_sums[i - k + 1] = sum;
        }

        // Compute the best indices from the left
        int best_left = 0;
        for (int i = 0; i < k_sums.size(); i++) {
            if (k_sums[i] > k_sums[best_left]) {
                best_left = i;
            }
            left[i] = best_left;
        }

        // Compute the best indices from the right
        int best_right = k_sums.size() - 1;
        for (int i = k_sums.size() - 1; i >= 0; i--) {
            if (k_sums[i] >= k_sums[best_right]) {
                best_right = i;
            }
            right[i] = best_right;
        }

        // Find the maximum sum by iterating over the middle subarray
        int max_sum = 0;
        for (int mid = k; mid < k_sums.size() - k; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];
            int total = k_sums[l] + k_sums[mid] + k_sums[r];
            if (total > max_sum) {
                max_sum = total;
                result = {l, mid, r};
            }
        }

        return result;
    }
};

int main() {
    Solution solution;
    vector<int> nums = {1, 2, 1, 2, 6, 7, 5, 1};
    int k = 2;
    vector<int> result = solution.maxSumOfThreeSubarrays(nums, k);
    for (int index : result) {
        cout << index << " ";
    }
    return 0;
}
