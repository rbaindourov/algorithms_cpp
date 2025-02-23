#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maxLength(const string &s)
    {
        stack<int> st;
        st.push(-1); // Base index for valid substring
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] == '(')
            {
                st.push(i);
            }
            else
            { // s[i] == ')'
                st.pop();
                if (!st.empty())
                {
                    maxLen = max(maxLen, i - st.top());
                }
                else
                {
                    st.push(i); // Reset base index
                }
            }
        }

        return maxLen;
    }
};

// Driver Code
int main()
{

    Solution ob;
    cout << ob.maxLength(string(")()())")) << "\n";

    return 0;
}

/*
int maxLength(const string &s)
{
    int maxLen = 0;
    int len = 0;
    stack<char> st;

    for (char c : s) {
        if (c == '(') {
            st.push(c);
        } else if (c == ')') {
            if (!st.empty()) {
                st.pop();
                len += 2;
                if (st.empty()) {
                    maxLen = max(maxLen, len);
                }
            } else {
                len = 0;
            }
        }
    }

    return maxLen;
}

*/