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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if( root == null ) return answer;
        q.add( root );
        boolean leftToRight = true; // A flag to control the zigzag direction
        
        while( !q.isEmpty() ) {
         
            int levelSize = q.size();
            List<Integer> row = new ArrayList<>();
            for( int i = 0; i < levelSize; i++ ){
                
                TreeNode node = q.poll();
                 if (leftToRight) {
                    row.add(node.val);
                } else {
                    row.add(0, node.val); // Insert at the beginning for reverse order
                }

                    if( node.left != null ) q.add( node.left );
                    if( node.right != null ) q.add( node.right);
             
                
            
            }
            answer.add(row);
            leftToRight = !leftToRight; 

        }
        return answer;
    }
}
