//
// Created by robert on 12/18/24.
//
#include <vector>
#include <iostream>

using namespace std;

int maxChunksToSorted(const vector<int>& arr) {
   int chunks = 0, i =0;;

   while(i < arr.size()){
     int start = i;
     int max_val = arr[start];
     while( i < arr.size() && max_val >= i ){
       max_val = max(max_val, arr[i]);
       ++i;
     }
     ++chunks;
   }

   return chunks;
}

vector<vector<int>> findChunks(const vector<int>& arr) {
  int i =0;
  vector<vector<int>> chunks;
  while(i < arr.size()){
    int start = i;
    int max_val = arr[start];
    while( i < arr.size() && max_val >= i ){
      max_val = max(max_val, arr[i]);
      ++i;
    }
    cout << "[";
    vector<vector<int> > chunks = findChunks({4, 3, 1, 2, 3});
    for (size_t i = 0; i < chunks.size(); ++i) {
      cout << "[";
      for (size_t j = 0; j < chunks[i].size(); ++j) {
        cout << chunks[i][j];
        if (j != chunks[i].size() - 1) cout << ", ";
      }
      cout << "]";
      if (i != chunks.size() - 1) cout << ", ";
    }
    cout << "]";
  }

}

int main(int argc, char *argv[]) {
  // cout << maxChunksToSorted({4,3,2,1,0}) << endl;
  // cout << maxChunksToSorted({1,0,2,3,4}) << endl;
  // cout << maxChunksToSorted({1,2,3,4,5}) << endl;



  cout << "[";
  vector<vector<int> > chunks = findChunks({4, 3, 1, 2, 3});
  for (size_t i = 0; i < chunks.size(); ++i) {
    cout << "[";
    for (size_t j = 0; j < chunks[i].size(); ++j) {
      cout << chunks[i][j];
      if (j != chunks[i].size() - 1) cout << ",";
    }
    cout << "]";
    if (i != chunks.size() - 1) cout << ",";
  }
  cout << "]";

  return 0;
}