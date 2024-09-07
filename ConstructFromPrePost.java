 // Definition for a binary tree node.
  class TreeNode {
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


public class ConstructFromPrePost {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        if (preStart == preEnd) {
            return root;
        }
        
        int leftRootIndex = indexOf(postorder, preorder[preStart + 1], postStart, postEnd - 1);
        int leftSubtreeSize = leftRootIndex - postStart + 1;
        
        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize, postorder, postStart, leftRootIndex);
        root.right = buildTree(preorder, preStart + leftSubtreeSize + 1, preEnd, postorder, leftRootIndex + 1, postEnd - 1);
        
        return root;
    }
    
    private int indexOf(int[] arr, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ConstructFromPrePost constructFromPrePost = new ConstructFromPrePost();
        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        TreeNode root = constructFromPrePost.constructFromPrePost(preorder, postorder);
        System.out.println(root);
    }
}