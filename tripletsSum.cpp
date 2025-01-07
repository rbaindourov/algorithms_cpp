#include <bits/stdc++.h>
using namespace std;

int countTriplets(vector<int>& arr, int target) {
    int n = arr.size();
    int count = 0;

    for (int i = 0; i < n - 2; i++) {
        int j = i + 1, k = n - 1;

        while (j < k) {
            int currentSum = arr[i] + arr[j] + arr[k];

            if (currentSum == target) {
                // Count duplicates for arr[j]
                int left = 1, right = 1;

                while (j + 1 < k && arr[j] == arr[j + 1]) {
                    j++;
                    left++;
                }

                // Count duplicates for arr[k]
                while (k - 1 > j && arr[k] == arr[k - 1]) {
                    k--;
                    right++;
                }

                // Add all combinations of duplicates
                count += left * right;

                // Move pointers
                j++;
                k--;
            } else if (currentSum < target) {
                j++; // Increase sum
            } else {
                k--; // Decrease sum
            }
        }
    }

    return count;
}

int main() {
    vector<int> arr = {-3, -1, -1, 0, 1, 2};
    int target = -2;

    cout << "Number of triplets: " << countTriplets(arr, target) << endl;

    return 0;
}
