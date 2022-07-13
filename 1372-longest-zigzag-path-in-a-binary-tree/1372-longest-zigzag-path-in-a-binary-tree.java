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
    public int longestZigZag(TreeNode root) {
        ans=0;
        find(root);
        return ans;
    }
    
   int[] find(TreeNode root){
        if(root==null) return new int[]{-1,-1};
        
        int left[]=find(root.left);
        int right[]=find(root.right);
        
        int a[]=new int[]{left[1]+1,right[0]+1};
        ans=Math.max(ans,Math.max(a[0],a[1]));
        return a;
    }
}






