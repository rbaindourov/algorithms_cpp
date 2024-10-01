#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

class TrieNode {
public:
    unordered_map<char, TrieNode*> children;
    string word;

    TrieNode() : word("") {}
};

class Solution {
public:
    TrieNode* buildTrie(const vector<string>& words) {
        TrieNode* root = new TrieNode();
        for (const string& word : words) {
            TrieNode* node = root;
            for (char c : word) {
                if (node->children.find(c) == node->children.end()) {
                    node->children[c] = new TrieNode();
                }
                node = node->children[c];
            }
            node->word = word;  // Store the word at the leaf node
        }
        return root;
    }

    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        TrieNode* root = buildTrie(words);
        vector<string> result;
        int m = board.size();
        int n = board[0].size();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (root->children.find(board[i][j]) != root->children.end()) {
                    dfs(board, i, j, root, result);
                }
            }
        }

        return result;
    }

private:
    void dfs(vector<vector<char>>& board, int i, int j, TrieNode* node, vector<string>& result) {
        char c = board[i][j];
        TrieNode* next_node = node->children[c];

        if (!next_node->word.empty()) {
            result.push_back(next_node->word);
            next_node->word = "";  // To avoid duplicates
        }

        board[i][j] = '#';  // Mark the cell as visited

        // Explore the 4 directions (up, down, left, right)
        vector<pair<int, int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (auto [dx, dy] : directions) {
            int x = i + dx, y = j + dy;
            if (x >= 0 && x < board.size() && y >= 0 && y < board[0].size() && 
                board[x][y] != '#' && next_node->children.find(board[x][y]) != next_node->children.end()) {
                dfs(board, x, y, next_node, result);
            }
        }

        board[i][j] = c;  // Restore the cell after DFS

        // Optimization: prune the TrieNode if it becomes a dead-end
        if (next_node->children.empty()) {
            node->children.erase(c);
        }
    }
};

// Example usage:
int main() {
    Solution solver;
    vector<vector<char>> board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };
    vector<string> words = {"oath", "pea", "eat", "rain"};

    vector<string> result = solver.findWords(board, words);

    for (const string& word : result) {
        cout << word << " ";
    }
    // Output: oath eat
    return 0;
}
