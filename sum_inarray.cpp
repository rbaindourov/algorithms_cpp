
#include <iostream>
#include <string>
#include <map>
#include <vector>

using namespace std;

struct answer{
    int a;
    int b;
};

//squarepanda question 
answer sum_exists (vector<int> a, int sum ) {
     struct answer indexes = {-1,-1};
     map<int,int> m;
          
     for ( int i =0; i<a.size(); i++ ) {
         cout<<a[i]<<endl;
         int value = sum - a[i];

         if( m.find(a[i]) != m.end() ){             
             indexes = { m[a[i]], i};
             return indexes;         
         } else {
             m.insert({value,i});
         }
            
     }
    
    return indexes;
}
//O(n)
int main(int argc, char *argv[], char *envp[] ){
    vector<int> a {1,2,3,4,5,6,7,8,9};
    struct answer result = sum_exists( a, 9);    
    cout << result.a<< "  " << result.b<<endl;
    cout << a[result.a] + a[result.b];
}