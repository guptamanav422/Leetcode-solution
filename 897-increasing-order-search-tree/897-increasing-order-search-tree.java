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
    TreeNode prev=null,head=null;
    public TreeNode increasingBST(TreeNode root)
    {
        if(root==null) return head;
        increasingBST(root.left);
        if(head==null) head=root;
        if(prev!=null)
        {
            root.left=null;
            prev.right=root;
        }
        prev=root;
        increasingBST(root.right);
        return head;
    }
}