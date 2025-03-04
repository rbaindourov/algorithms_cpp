#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

vector<int> getFinalState(vector<int>& nums, int k, int multiplier) {
    // Min-heap to store pairs of (value, index)
    priority_queue<tuple<int, int>, vector<tuple<int, int>>, greater<tuple<int, int>>> minHeap;

    // Step 1: Push all elements into the min-heap
    for (int i = 0; i < nums.size(); i++) {
        minHeap.push({nums[i], i});
    }

    // Step 2: Perform k operations
    for (int i = 0; i < k; i++) {
        // Extract the smallest element from the min-heap
        auto [value, index] = minHeap.top(); // Get the top element (smallest)
        minHeap.pop(); // Remove it from the heap

        // Update the value in the original array
        nums[index] = value * multiplier;

        // Push the updated value back into the min-heap
        minHeap.push({nums[index], index});
    }

    // Step 3: Return the modified array
    return nums;
}

int main() {
    vector<int> nums = {2, 3, 1, 5, 1}; // Example array
    int k = 2;                          // Number of operations
    int multiplier = 4;                 // Multiplier

    vector<int> result = getFinalState(nums, k, multiplier);

    // Output the result
    for (int num : result) {
        cout << num << " ";
    }

    return 0;
}