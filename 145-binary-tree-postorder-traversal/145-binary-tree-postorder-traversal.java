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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        
        while(curr!=null){
            
            if(curr.right==null){
                ans.add(curr.val);
                curr=curr.left;
            }
            else{
                TreeNode next=curr.right;
                while(next.left!=null && next.left!=curr) next=next.left;
                
                if(next.left==null){
                    next.left=curr;
                    ans.add(curr.val);
                    curr=curr.right;
                }
                else{
                    next.left=null;
                    curr=curr.left;
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}