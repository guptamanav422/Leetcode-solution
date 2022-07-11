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
    public List<Integer> rightSideView(TreeNode root)
    {
        if(root==null) return new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            while(s-->0){
                TreeNode n=q.remove();
                 if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
                if(s==0){
                    ans.add(n.val);
                }
            }
        }
        return ans;
    }
}