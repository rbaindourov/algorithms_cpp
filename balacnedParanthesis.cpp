//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution
{
public:
    bool isBalanced(string &s)
    {

        stack<char> st;
        unordered_map<char, char> mp = {
            {'{', '}'},
            {'(', ')'},
            {'[', ']'}};

        for (char c : s)
        {

            if (mp.count(c))
                st.push(c);

            else
            {

                if (st.empty() || mp[st.top()] != c)
                    return false;

                st.pop();
            }
        }

        return st.empty();
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    string a;
    cin >> t;
    while (t--)
    {
        cin >> a;
        Solution obj;
        if (obj.isBalanced(a))
            cout << "true" << endl;
        else
            cout << "false" << endl;

        cout << "~"
             << "\n";
    }
}
// } Driver Code Ends