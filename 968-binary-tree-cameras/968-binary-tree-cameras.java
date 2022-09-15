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
    int res=0;
    public int minCameraCover(TreeNode root) {
        
        return (find(root)<1?1:0)+res;
    }
    int find(TreeNode root){
        if(root==null) return 2;
        
        int left=find(root.left),right=find(root.right);
        
        if(left==0 || right==0){
            res++;
            return 1;
        }
        if(left==1 || right==1) return 2;
        
        else return 0;
    }
}