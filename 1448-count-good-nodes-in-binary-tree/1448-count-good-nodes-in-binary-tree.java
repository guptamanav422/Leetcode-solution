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
    public int goodNodes(TreeNode root) {
        return findTotalGoodNodes(root,root.val);
    }
    int findTotalGoodNodes(TreeNode root,int max){
        
        if(root==null) return 0;
        
        int left=findTotalGoodNodes(root.left,Math.max(max,root.val));
        int right=findTotalGoodNodes(root.right,Math.max(max,root.val));
        
        int ansTillCurrNode=(max<=root.val)?1:0;
        
        return ansTillCurrNode + left + right;
    }
}