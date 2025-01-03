#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int eraseOverlapIntervals(vector<vector<int>>& intervals) {
    if (intervals.empty()) return 0;

    // Sort intervals by their end time
    sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
        return a[1] < b[1];
    });

    int count = 0;
    int prev_end = intervals[0][1]; // End time of the first interval

    for (int i = 1; i < intervals.size(); i++) {
        // If the current interval overlaps with the previous, remove it
        if (intervals[i][0] < prev_end) {
            count++;
        } else {
            // Otherwise, update prev_end to the current interval's end
            prev_end = intervals[i][1];
        }
    }

    return count;
}

int main() {
    vector<vector<int>> intervals = {{1, 3}, {2, 4}, {3, 5}, {6, 8}};

    cout << "Minimum intervals to remove: " << eraseOverlapIntervals(intervals) << endl;

    return 0;
}
