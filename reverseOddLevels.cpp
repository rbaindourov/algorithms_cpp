class Solution {
public:
    TreeNode* reverseOddLevels(TreeNode* root) {
        if (root == nullptr) return nullptr;

        deque<TreeNode*> q;
        q.push_back(root);
        int level = 0;

        while (!q.empty()) {
            int size = q.size();

            // If it's an odd level, swap values of nodes
            if (level % 2 == 1) {
                int left = 0, right = size - 1;

                // Swap values from left to right for the current level
                while (left < right) {
                    swap(q[left]->val, q[right]->val);
                    ++left;
                    --right;
                }
            }

            // Add all nodes at this level to the deque for the next level
            for (int i = 0; i < size; ++i) {
                TreeNode* node = q.front();
                q.pop_front();

                if (node->left != nullptr) q.push_back(node->left);
                if (node->right != nullptr) q.push_back(node->right);
            }

            ++level; // Move to the next level
        }

        return root;
    }
};
