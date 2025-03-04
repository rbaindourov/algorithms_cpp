#include <iostream>
#include <vector>
using namespace std;

int findMinimum(const vector<int>& arr) {
    int low = 0, high = arr.size() - 1;

    // Binary search to find the minimum element
    while (low < high) {
        int mid = low + (high - low) / 2;

        // If middle element is greater than the last element,
        // the minimum must be in the right half
        if (arr[mid] > arr[high]) {
            low = mid + 1;
        } 
        // Otherwise, the minimum is in the left half (or could be at mid)
        else {
            high = mid;
        }
    }

    // At this point, low == high and points to the minimum element
    return arr[low];
}

int main() {
    vector<int> arr = {5, 6, 1, 2, 3, 4}; // Example rotated array
    cout << "The minimum element is: " << findMinimum(arr) << endl;

    return 0;
}