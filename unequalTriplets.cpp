//
// Created by robert on 1/3/25.
//
#include <bits/stdc++.h>
using namespace std;

int unequalTriplets(vector<int>& nums) {
    int n = nums.size();
    int counter = 0;

    // Frequency map: store the count of each element in the array
    unordered_map<int, int> map;
    for (int n : nums) {
        map[n]++;
    }

    // Initialize left and right pointers
    int left = 0;
    int right = n;

    // Iterate through the frequency map
    for (auto [n, count] : map) {
        // Update the right pointer: subtract the count of the current number
        right -= count;

        // Calculate the number of triplets formed using the current number 'n'
        counter += left * count * right;

        // Update the left pointer: add the count of the current number
        left += count;
    }

    return counter;
}

int main() {
    vector<int> arr = {10,4,8,7};
    cout << "Number of triplets: " << unequalTriplets(arr) << endl;
    return 0;
}