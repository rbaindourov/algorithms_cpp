#include <vector>
#include <map>
#include <utility>
#include <iostream>
using namespace std;

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    map<pair<int,int>,vector<TreeNode*>> dp;
    vector<TreeNode*> solve(int st,int end){
        vector<TreeNode*> ans;
        if(st>end){
            ans.push_back(NULL);
            return ans;
        }
        if(st==end){
            TreeNode* node=new TreeNode(st);
            ans.push_back(node);
            return ans;
        }
        if(dp.count({st,end})){
            return dp[{st,end}];
        }
        for(int i=st;i<=end;i++){
            vector<TreeNode*> left=solve(st,i-1);
            vector<TreeNode*> right=solve(i+1,end);
            for(auto it:left){
                for(auto jt:right){
                    TreeNode* root=new TreeNode(i);
                    root->left=it;
                    root->right=jt;
                    ans.push_back(root);
                }
            }
        }
        dp[{st,end}]=ans;
        return ans;
    }
    vector<TreeNode*> generateTrees(int n) {
        return solve(1,n);
    }
};

void printTree(TreeNode* node) {
    if (node == nullptr) {
        cout << "null ";
        return;
    }
    cout << node->val << " ";
    printTree(node->left);
    printTree(node->right);
}

int main() {
    Solution solution;
    vector<TreeNode*> result = solution.generateTrees(3);
    // Print the result or use it as needed
    for (TreeNode* node : result) {
        // Function to print the tree (in-order traversal)
        printTree(node);
        cout << endl;
    }
    //generate test cases
    vector<TreeNode*> test_cases = solution.generateTrees(3);
    for (TreeNode* node : test_cases) {
        printTree(node);
        cout << endl;
    }

    vector<TreeNode*> test_cases2 = solution.generateTrees(1);
    for (TreeNode* node : test_cases2) {
        printTree(node);
        cout << endl;
    }
    return 0;
}