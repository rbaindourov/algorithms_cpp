/*
Medium
Topics
Companies
Hint
Given a binary tree root and a linked list with head as the first node. 

Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.

 

Example 1:



Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.  
Example 2:



Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Example 3:

Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
*/


//Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//Definition for a binary tree node.
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


 class LinkedListBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }

    public static void main(String[] args) {
        LinkedListBinaryTree solution = new LinkedListBinaryTree();
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(8)));
        TreeNode root = new TreeNode(1,
            new TreeNode(4,
                new TreeNode(2,
                    new TreeNode(1),
                    null
                ),
                new TreeNode(2,
                    new TreeNode(6),
                    new TreeNode(8)
                )
            ),
            new TreeNode(4,
                null,
                new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)
                )
            )
        );
        System.out.println(solution.isSubPath(head, root)); // Output: true
    }
}