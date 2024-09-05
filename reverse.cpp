#include <iostream>
#include <string>
#include <algorithm>    
#include <climits>

using namespace std;
int reverse(int x) {
    int reversed = 0;
    while (x != 0) {
        // Check for overflow before adding the next digit
        if (reversed > INT_MAX / 10 || reversed < INT_MIN / 10) {
            return 0;  // Return 0 if overflow would occur
        }
        int digit = x % 10;
        reversed = reversed * 10 + digit;
        x /= 10;
    }
    return reversed;
}


int main(){
    int x = 123;
    string s = to_string(x);
    reverse(s.begin(), s.end());
    cout << s << endl;
    return 0;
}