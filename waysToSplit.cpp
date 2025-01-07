//
// Created by robert on 1/3/25.
//
#include <iostream>
#include <vector>

using namespace std;

int waysToSplitArray(vector<int>& nums) {

    vector<int> prefixSums;
    int totalSum = 0;
    for( int n : nums ){
        prefixSums.push_back(totalSum+=n);
    }

    int count = 0;

    for( int i = 0; i < prefixSums.size()-1; i++ ){
        if( prefixSums[i] >= (totalSum-prefixSums[i]) )
            count++;
    }

    return count;
}

int main(){

    vector<int> arr {10,4,-8,7};
    cout<< waysToSplitArray(arr);

    vector<int> arr1 {10,4,-8,7};
    cout<< waysToSplitArray(arr1);

    vector<int> arr2 {10,-1,7};
    cout<< waysToSplitArray(arr2);

}