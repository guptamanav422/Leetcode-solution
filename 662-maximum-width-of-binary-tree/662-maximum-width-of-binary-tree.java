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
        TreeNode n;
        int l;
        pair(TreeNode a,int b){
            n=a;
            l=b;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));
        int ans=1;
        while(!q.isEmpty()){
            int s=q.size();
            int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
            while(s-->0){
                pair temp=q.remove();
                
                min=Math.min(min,temp.l);
                max=Math.max(max,temp.l);
                
                TreeNode a=temp.n;
                if(a.left!=null){
                    q.add(new pair(a.left,temp.l*2+1));
                }
                if(a.right!=null){
                    q.add(new pair(a.right,temp.l*2+2));
                }
            }
            if(max-min+1>ans) ans=max-min+1;
        }
        return ans;
    }
}