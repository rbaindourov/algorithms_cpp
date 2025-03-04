#include <string>
#include <vector>
#include <iostream>
#include <functional> // Include this for std::function

using namespace std;

vector<string> generateParenthesis(int n) {
    vector<string> solutions;

    // Explicitly declare the lambda with std::function
    function<void(string, int, int)> backtrack = [&](const string& current, int open, int close) {
        if (current.length() == n * 2) {
            solutions.push_back(current);
            return;
        }
        if (open < n) {
            backtrack(current + '(', open + 1, close);
        }
        if (close < open) {
            backtrack(current + ')', open, close + 1);
        }
    };

    // Start the backtracking
    backtrack("", 0, 0);

    return solutions;
}

// Main function
int main() {
    int n = 3; // Example input
    vector<string> result = generateParenthesis(n);
    cout << "Number of solutions: " << result.size() << endl;
    // Print the results
    for (const auto &str: result) {
        cout << str << endl;
    }

    return 0;
}