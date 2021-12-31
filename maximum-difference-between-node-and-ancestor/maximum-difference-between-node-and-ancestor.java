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
    int ans=0;
    public int maxAncestorDiff(TreeNode root)
    {
        ans=Integer.MIN_VALUE;
        find(root,-1,1000000);
        return ans;
    }
    void find(TreeNode root,int max,int min){
        
        if(root==null) return;
        if(max!=-1)
        ans=Math.max(ans,max-root.val);
        
        if(min!=1000000)
        ans=Math.max(ans,root.val-min);
        
        find(root.left,Math.max(root.val,max),Math.min(root.val,min));
        find(root.right,Math.max(root.val,max),Math.min(root.val,min));
    }
}