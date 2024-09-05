#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <bits/stdc++.h>
using namespace std;


int main()
{
    
    map<string,vector<string>> anagrams;
    vector<string> msg = { "black", "blue", "elbow", "below", "bake", "kabe", "keep", "peek", "knee", "kene","neek"};
    for (string& word : msg){
        const string copied_word = word;
        sort(word.begin(), word.end());
        if( anagrams.find(word) !=anagrams.end() ){
            anagrams[word].push_back(copied_word);
        }else{
            anagrams[word] = {copied_word}; 
        };
    };

    for(auto& anagram : anagrams){
        cout << anagram.first << " : ";
        for(auto& word : anagram.second){
            cout << word << " ";
        }
        cout << endl;
    }

    for(auto& anagram : anagrams){  
        if(anagram.second.size() > 1){
            cout << "Anagram group: ";
            for(auto& word : anagram.second){
                cout << word << " ";
            }
            cout << endl;
        }
    }   

    return 0;
}
