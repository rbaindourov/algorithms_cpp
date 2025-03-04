//
// Created by robert on 12/19/24.
//


#include <iostream>
#include <vector>

using namespace std;

    int kthMissing(vector<int> &arr, int k) {
        // Your code goes here
        int current = 1;
        int n  = arr.size();
        vector<int> missing;

        for( int i = 0; i < n; i++ ){

           while( current < arr[i] ){
             missing.push_back( current );
             current++;
           }
           current++;

        }
        while( missing.size() < k ) {
          missing.push_back( current );
          current++;
        }

        return missing[k-1];

    };

//