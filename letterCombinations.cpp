//
// Created by robert on 12/20/24.
//
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;
void backtrack(string & digits, const int index, string & current, vector<string> & result, const unordered_map<char,string> & map) {
  if (digits.length() == index) {
    result.push_back(current);
    return;
  }
   char digit = digits[index];
   string letters = map.find(digit)->second;
   for( char letter : letters ) {
        current.push_back(letter);
        backtrack( digits, index+1, current, result, map );
        current.pop_back();
   }

}
vector<string> letterCombinations(string digits) {
    vector<string> result;
    string current;

    if (digits.empty()) return result;

    unordered_map<char, string> map;

    map.insert(make_pair('2', "abc"));
    map.insert(make_pair('3', "def"));
    map.insert(make_pair('4', "ghi"));
    map.insert(make_pair('5', "jkl"));
    map.insert(make_pair('6', "mno"));
    map.insert(make_pair('7', "pqrs"));
    map.insert(make_pair('8', "tuv"));
    map.insert(make_pair('9', "wxyz"));


    backtrack(digits, 0, current,  result, map);
    return result;

}

int main(){
    vector<string> result = letterCombinations("23");
    for (const auto & i : result) {
      cout << i << endl;
    }
}