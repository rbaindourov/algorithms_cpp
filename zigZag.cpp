#include <iostream>
#include <vector>
#include <queue>
#include <stack>
using namespace std;

// Definition for a binary tree node
struct TreeNode {
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// Function to perform zig-zag level order traversal
vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
    vector<vector<int>> result;
    if (!root) return result; // Return empty if the tree is empty

    queue<TreeNode*> q; // Queue for level-order traversal
    q.push(root);
    bool leftToRight = true; // Start with left-to-right traversal

    while (!q.empty()) {
        int size = q.size(); // Number of nodes at the current level
        vector<int> level(size);

        for (int i = 0; i < size; i++) {
            TreeNode* node = q.front();
            q.pop();

            // Determine position based on traversal direction
            int index = leftToRight ? i : size - 1 - i;
            level[index] = node->val;

            // Enqueue left and right children
            if (node->left) q.push(node->left);
            if (node->right) q.push(node->right);
        }

        // Add the current level to the result
        result.push_back(level);

        // Switch traversal direction for the next level
        leftToRight = !leftToRight;
    }

    return result;
}

// Helper function to print the result
void printZigzagTraversal(const vector<vector<int>>& traversal) {
    for (const auto& level : traversal) {
        for (int val : level) {
            cout << val << " ";
        }
        cout << endl;
    }
}

// Example usage
int main() {
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->right->left = new TreeNode(6);
    root->right->right = new TreeNode(7);

    vector<vector<int>> result = zigzagLevelOrder(root);
    cout << "Zig-Zag Level Order Traversal:" << endl;
    printZigzagTraversal(result);

    return 0;
}
