//
// Created by robert on 12/15/24.
//
#include <iostream>
#include <vector>
using namespace std;

int findPeakElement(const vector<int>& arr) {
    int n = arr.size();
    int low = 0, high = n - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        // Check if the mid element is a peak
        if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
            (mid == n - 1 || arr[mid] > arr[mid + 1])) {
            return mid; // Peak found
        }

        // If the left neighbor is greater, search on the left side
        if (mid > 0 && arr[mid - 1] > arr[mid]) {
            high = mid - 1;
        }
        // Otherwise, search on the right side
        else {
            low = mid + 1;
        }
    }

    return -1; // This should never be reached
}

int main() {
    vector<int> arr = {1, 2, 4, 5, 7, 8, 3};
    int peakIndex = findPeakElement(arr);
    cout << "Peak element index: " << peakIndex << endl;
    return 0;
}