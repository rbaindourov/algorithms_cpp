class Solution {
public:
    TreeNode* reverseOddLevels(TreeNode* root) {
        if( root == NULL ) return NULL;

        deque<TreeNode*> q;
        q.push_back(root);
        int level = 0;

        while( !q.empty() ){
            int size = q.size();
            if( level & 1 ){
                int l = 0, r = size -1;

                while( l < r){
                    swap(q[l]->val, q[r]->val);
                    l++;
                    r--;
                }
            }

            for(int i =0; i < q.size(); i++){
                TreeNode* node = q.front();
                q.pop_front();

                if (node->left != nullptr) q.push_back(node->left);
                if (node->right != nullptr) q.push_back(node->right);
            }


            ++level;
        }

        return root;
    }
};