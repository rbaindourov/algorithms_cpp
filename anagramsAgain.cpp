//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    vector<vector<string>> anagrams(vector<string>& arr) {
        // code here
        unordered_map<string,vector<string>> um;
        vector<vector<string>> result;
        
        for( string str : arr ){
            string key = str;
            sort( key.begin(), key.end() );
            um[key].emplace_back(str);
        }
        
        for( auto kvp: um ){
            result.emplace_back(kvp.second);
        }
        
        return result;
    }
};
