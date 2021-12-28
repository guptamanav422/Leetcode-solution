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
    public int sumEvenGrandparent(TreeNode root) {
        return find(root,null,null);
    }
    int find(TreeNode root,TreeNode par,TreeNode grand){
        
        if(root==null) return 0;
        
        int left=find(root.left,root,par);
        int right=find(root.right,root,par);
        
        return left+right+((grand==null || grand.val%2!=0)?0:root.val);
    }
}