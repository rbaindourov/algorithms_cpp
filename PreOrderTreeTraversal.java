import java.util.ArrayList;
import java.util.List;

public class PreOrderTreeTraversal {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorderTraversalHelper(root, result);
            return result;
        }

        private void preorderTraversalHelper(TreeNode root, List<Integer> result) {
            if (root == null) return;
            result.add(root.val);
            preorderTraversalHelper(root.left, result);
            preorderTraversalHelper(root.right, result);
        }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postOrderTraversalHelper( root, result);
        return result;
    }

    private void postOrderTraversalHelper(TreeNode node, List<Integer> result){
        if( node == null ) return;
        postOrderTraversalHelper( node.left, result);
        postOrderTraversalHelper( node.right, result);
        result.add(node.val);
    }
}           



    //generate test cases
    public static void main(String[] args) {
        PreOrderTreeTraversal preOrderTreeTraversal = new PreOrderTreeTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(preOrderTreeTraversal.preorderTraversal(root));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    


