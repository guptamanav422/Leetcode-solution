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
class Solution
{
    TreeNode node=null;
    public boolean check(TreeNode root,TreeNode curr,int val)
    {
        if(root==null) return false;
        return (root.val>val) && check(root.left,curr,val) || 
            (root.val<val) && check(root.right,curr,val) || 
            root.val==val &&curr!=root;
    }
    public boolean findTarget(TreeNode root, int k)
    {
        if(root==null) return false;
        if(node==null) node=root;
        return check(node,root,k-root.val) ||
            findTarget(root.left,k) ||findTarget(root.right,k);
    }
}