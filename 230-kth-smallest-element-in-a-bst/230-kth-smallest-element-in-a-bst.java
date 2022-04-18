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
    int count=0;
    int nodes(TreeNode root)
    {
        if(root==null) return 0;
        return 1+nodes(root.left)+nodes(root.right);
    }
    public int kthSmallest(TreeNode root, int k)
    {
       if(root==null) return 0;
       int left=nodes(root.left);
       if((left+1)>k)
       {
           return kthSmallest(root.left,k);
       }
       else if((left+1)<k)
       {
           k=k-(left+1);
           return kthSmallest(root.right,k);
       }
       else return root.val;
    }
}