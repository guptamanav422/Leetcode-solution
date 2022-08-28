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
    class pair{
        int left,right;
        pair(int left,int right){
            this.left=left;
            this.right=right;
        }
    }
    int ans=0;
    public int longestZigZag(TreeNode root) {
        
       longestZigZapHelper(root);
        return ans;
    }
    public pair longestZigZapHelper(TreeNode root){
        
        if(root==null) return new pair(-1,-1);
        
        pair leftChild=longestZigZapHelper(root.left);
        pair rightChild=longestZigZapHelper(root.right);
        
        pair res=new pair(leftChild.right+1,rightChild.left+1);
        ans=Math.max(ans,Math.max(res.left,res.right));
        return res;
    }
}