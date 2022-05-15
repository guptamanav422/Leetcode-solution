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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int sum=0;
        while(!q.isEmpty()){
            sum=0;
            int s=q.size();
            while(s-->0){
                TreeNode n=q.remove();
                sum+=n.val;
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
        }
        return sum;
    }
}