
#include <iostream>
#include <string>
using namespace std;
//autodesk question 
int binary_search ( int a[], int value, int right, int left) {
    while( right >= left ) {
        int middle = (left+right)/2;
        if( value == a[middle] ) return middle;
        if( value < a[middle] ) 
            right = middle -1;
        else
            left = middle +1;
    }

}

int main(int argc, char *argv[], char *envp[] ){
int a[] = {1,2,3,4,5,6};
cout<<"hello world2";
cout<<binary_search( a, 9, 0,5);
    
}