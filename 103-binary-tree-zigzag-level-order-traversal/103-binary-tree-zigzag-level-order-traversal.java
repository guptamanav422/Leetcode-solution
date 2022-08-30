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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Deque<TreeNode> q= new LinkedList<>();
 
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        boolean ok=true;
        
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer> temp=new ArrayList<>();
            while(s-->0){
                
                if(ok){
                    TreeNode num=q.remove();
                    temp.add(num.val);
                    if(num.left!=null) q.add(num.left);
                    if(num.right!=null) q.add(num.right);
                }
                else{
                    TreeNode num=q.removeLast();
                    temp.add(num.val);
                    if(num.right!=null) q.addFirst(num.right);
                    if(num.left!=null) q.addFirst(num.left);
                }
            }
            ok=!ok;
            ans.add(temp);
        }
        return ans;
    }
}