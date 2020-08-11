#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <bits/stdc++.h>
using namespace std;

//etrade question
int main()
{
    
    map<string,string> anagrams;
    vector<string> msg { "black", "blue", "elbow", "below"};
    for (string& word : msg){
        const string copied_word = word;
        sort(word.begin(), word.end());
        if( anagrams.find(word) !=anagrams.end() ){
            anagrams.insert({word,copied_word});
        }else{
            
        };
    };

    


}



