#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> findTriplets(vector<int>& arr) {
    vector<vector<int>> result;
    int n = arr.size();

    // Step 1: Create a vector of pairs (value, original index)
    vector<pair<int, int>> indexedArr;
    for (int i = 0; i < n; i++) {
        indexedArr.push_back({arr[i], i});
    }

    // Step 2: Sort the array based on the values (not indices)
    sort(indexedArr.begin(), indexedArr.end());

    // Step 3: Apply two-pointer technique
    for (int i = 0; i < n - 2; i++) {
        // Skip duplicate elements to avoid repeated triplets
        if (i > 0 && indexedArr[i].first == indexedArr[i - 1].first) continue;

        int left = i + 1, right = n - 1;
        while (left < right) {
            int sum = indexedArr[i].first + indexedArr[left].first + indexedArr[right].first;

            if (sum == 0) {
                // Found a valid triplet, add original indices
                vector<int> triplet = {indexedArr[i].second, indexedArr[left].second, indexedArr[right].second};

                // Sort the indices to ensure i < j < k
                sort(triplet.begin(), triplet.end());

                result.push_back(triplet);

                // Skip duplicates for left and right pointers
                while (left < right && indexedArr[left].first == indexedArr[left + 1].first) left++;
                while (left < right && indexedArr[right].first == indexedArr[right - 1].first) right--;

                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    // Return the result
    return result;
}

int main() {
    vector<int> arr1 = {0, -1, 2, -3, 1};
    vector<vector<int>> result1 = findTriplets(arr1);

    cout << "Triplets for arr1: " << endl;
    for (const auto& triplet : result1) {
        cout << "[" << triplet[0] << ", " << triplet[1] << ", " << triplet[2] << "]" << endl;
    }

    vector<int> arr2 = {1, -2, 1, 0, 5};
    vector<vector<int>> result2 = findTriplets(arr2);

    cout << "Triplets for arr2: " << endl;
    for (const auto& triplet : result2) {
        cout << "[" << triplet[0] << ", " << triplet[1] << ", " << triplet[2] << "]" << endl;
    }

    vector<int> arr3 = {2, 3, 1, 0, 5};
    vector<vector<int>> result3 = findTriplets(arr3);

    cout << "Triplets for arr3: " << endl;
    if (result3.empty()) {
        cout << "[ ]" << endl;
    } else {
        for (const auto& triplet : result3) {
            cout << "[" << triplet[0] << ", " << triplet[1] << ", " << triplet[2] << "]" << endl;
        }
    }

    return 0;
}
