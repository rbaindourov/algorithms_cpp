#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int numOperationsToEmpty(vector<int>& nums) {
    int operations = 0;
    int minimumValue = *min_element(nums.begin(), nums.end()); // Find the smallest value

    while (!nums.empty()) {
        // If the first element is the smallest, remove it
        if (nums.front() == minimumValue) {
            nums.erase(nums.begin()); // Remove the first element
            if (!nums.empty()) {
                // Update the new smallest value in the remaining array
                minimumValue = *min_element(nums.begin(), nums.end());
            }
        } else {
            // Otherwise, move the first element to the end of the array
            nums.push_back(nums.front());
            nums.erase(nums.begin());
        }

        // Increment the operation counter
        operations++;
    }

    return operations;
}

int main() {
    vector<int> nums = {3, 1, 2, 4}; // Example input
    cout << "Number of operations: " << numOperationsToEmpty(nums) << endl;
    return 0;
}