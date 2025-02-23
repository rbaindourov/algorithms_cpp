#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<int> calculateSpan(vector<int> &arr)
{
    int n = arr.size();
    vector<int> span(n, 0);
    stack<int> s; // Stack to store indices

    for (int i = 0; i < n; i++)
    {
        while (!s.empty() && arr[s.top()] <= arr[i])
        {
            s.pop();
        }

        span[i] = (s.empty()) ? (i + 1) : (i - s.top());
        s.push(i);
    }

    return span;
}

int main()
{
    vector<int> arr1 = {100, 80, 60, 70, 60, 75, 85};
    vector<int> result1 = calculateSpan(arr1);

    for (int val : result1)
    {
        cout << val << " ";
    }
    cout << endl;

    vector<int> arr2 = {10, 4, 5, 90, 120, 80};
    vector<int> result2 = calculateSpan(arr2);

    for (int val : result2)
    {
        cout << val << " ";
    }
    cout << endl;

    vector<int> arr3 = {11, 4, 5, 90, 120, 80};
    vector<int> result3 = calculateSpan(arr3);

    for (int val : result3)
    {
        cout << val << " ";
    }
    cout << endl;

    return 0;
}
