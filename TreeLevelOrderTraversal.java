//me

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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if( root == null ) return answer;
        q.add( root );
        while( !q.isEmpty() ) {
            int levelSize = q.size();
            List<Integer> row = new ArrayList<>();
            for( int i = 0; i < levelSize; i++ ){
                TreeNode node = q.poll();
                row.add(node.val);

                if( node.left != null ) q.add( node.left );
                if( node.right != null ) q.add( node.right);

            
            }
            answer.add(row);


        }
        return answer;
    }
}


//best
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
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public void dfs(TreeNode root , int level){
        if(root == null)return;
        if(ans.size() == level)ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        if(root.left != null)dfs(root.left , level + 1);
        if(root.right != null)dfs(root.right , level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root , 0);
        return ans;    
    }
}
