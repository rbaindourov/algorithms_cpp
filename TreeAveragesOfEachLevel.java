import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        if (root == null) return answer; // Handle edge case for empty tree

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            double levelSum = 0; // Sum of values at the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Get the current node
                levelSum += node.val; // Add its value to the level sum
                
                // Add child nodes to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Calculate the average for the current level
            double average = levelSum / levelSize;
            answer.add(average);
        }
        
        return answer; // Return the list of averages for each level
    }
}



import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        List<Integer> sums = new ArrayList<>(); // To store sums at each level
        List<Integer> counts = new ArrayList<>(); // To store counts at each level
        dfs(root, 0, sums, counts);
        
        // Calculate averages
        for (int i = 0; i < sums.size(); i++) {
            answer.add((double) sums.get(i) / counts.get(i));
        }
        
        return answer;
    }

    public void dfs(TreeNode root, int level, List<Integer> sums, List<Integer> counts) {
        if (root == null) return;
        
        // Ensure the lists are large enough
        if (level >= sums.size()) {
            sums.add(0); // Add a new sum for the new level
            counts.add(0); // Add a new count for the new level
        }
        
        // Update sum and count for the current level
        sums.set(level, sums.get(level) + root.val);
        counts.set(level, counts.get(level) + 1);
        
        // Recurse for left and right children
        dfs(root.left, level + 1, sums, counts);
        dfs(root.right, level + 1, sums, counts);
    }
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.AbstractList;

class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        return new AbstractList<Double>() {
            List<Double> result = new ArrayList<>();
            Queue<TreeNode> nodesInLevel = new LinkedList<>();

            @Override
            public Double get(int index) {
                init();
                return result.get(index);
            }

            @Override
            public int size() {
                init();
                return result.size();
            }

            private void init() {
                if (!result.isEmpty())
                    return;

                nodesInLevel.add(root);
                while (!nodesInLevel.isEmpty()) {
                    traversalLevel();
                }
            }

            private void traversalLevel() {
                double sum = 0.0;
                int levelCnt = nodesInLevel.size();
                for (int i = 0; i < levelCnt; i++) {
                    TreeNode node = nodesInLevel.poll();
                    sum += node.val;
                    if (node.left != null) {
                        nodesInLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nodesInLevel.add(node.right);
                    }
                }
                result.add(sum / levelCnt);
            }
        };
    }
}
