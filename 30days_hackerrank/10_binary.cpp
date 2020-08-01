#include <bits/stdc++.h>
using namespace std;


int main()
{
    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    int count = 0;
    int max = 0;

    while( n >= 1){
        if( n%2 == 1 ){
            count++;
        } else {
            if( count > max ) max = count;
            count = 0;
        }
        n=n/2;
    }
    if( count > max ) max = count;
    cout<<max;

    return 0;
}
