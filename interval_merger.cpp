#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> mergeIntervals(vector<vector<int>>& intervals) {
    // Step 1: Sort the intervals by start time
    sort(intervals.begin(), intervals.end());

    vector<vector<int>> merged; // Result to store merged intervals

    // Step 2: Iterate through the intervals
    for (auto& interval : intervals) {
        // If the merged list is empty or the current interval does not overlap with the last interval
        if (merged.empty() || merged.back()[1] < interval[0]) {
            merged.push_back(interval); // Add current interval to the result
        } else {
            // There is an overlap; merge the intervals by updating the end time
            merged.back()[1] = max(merged.back()[1], interval[1]);
        }
    }

    return merged; // Return the merged intervals
}

int main() {
    vector<vector<int>> intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

    vector<vector<int>> result = mergeIntervals(intervals);

    cout << "Merged Intervals: ";
    for (const auto& interval : result) {
        cout << "[" << interval[0] << ", " << interval[1] << "] ";
    }
    cout << endl;

    return 0;
}