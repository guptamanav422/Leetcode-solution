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
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root)
    {
        if(root==null) return true;
        boolean left=isValidBST(root.left);
        if(prev!=null && prev.val>=root.val) return false;
        prev=root;
        left&=isValidBST(root.right);
        return left;
    }
}