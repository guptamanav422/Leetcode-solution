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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,ans,0);
        return ans;
    }
    void dfs(TreeNode root,List<List<Integer>> ans,int l){
        if(root==null) return;
        if(ans.size()==l) ans.add(new ArrayList<>());
        ans.get(l).add(root.val);
        
        dfs(root.left,ans,l+1);
        dfs(root.right,ans,l+1);
    }
}