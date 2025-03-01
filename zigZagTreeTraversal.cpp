/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        
        vector<vector<int>> result;
        if( root == NULL ) return result;
        
        queue<TreeNode*> q;        
        int level = 1, size=1;
        
        q.push(root);

        while( !q.empty() ){            
            
            int levelSize = q.size();            
            vector<int> nodes;

            for( int i = 0; i < levelSize; i++){
                TreeNode* node = q.front();
                q.pop();

                nodes.emplace_back( node->val );

                if( node->left != nullptr){
                    q.push( node->left );
                    
                } 
                if( node->right != nullptr) {
                    q.push( node->right );                
                    
                }               
            }

            if( level % 2 == 0 ) reverse(nodes.begin(), nodes.end());
            result.emplace_back( nodes );
            level++;
            
        }

        return result;
    }
};