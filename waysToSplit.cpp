//
// Created by robert on 1/3/25.
//
#include <iostream>
#include <vector>

using namespace std;

int waysToSplitArray(vector<int>& nums) {


    int totalSum = 0;
    for( int n : nums ){
        totalSum+=n;
    }

    int count = 0;
    int prefixSum = 0;
    for( int i = 0; i < nums.size()-1; i++ ){
        prefixSum += nums[i];
        if ( totalSum > totalSum - prefixSum) count++;
    }

    return count;
}

int main(){

    vector<int> arr {10,4,-8,7};
    cout<< waysToSplitArray(arr);
    vector<int> arr2 {2,3,1,0};
    cout<< waysToSplitArray(arr2);
    vector<int> arr3 {6,-1,9};
    cout<< waysToSplitArray(arr);
}