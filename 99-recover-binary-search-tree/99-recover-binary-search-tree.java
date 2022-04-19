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
    public void recoverTree(TreeNode root) {
        TreeNode a=null,b=null,prev=null,node=root;
        while(root!=null){
            TreeNode ll=root.left;
            TreeNode temp=null;
            if(ll==null){
                temp=root;
                root=root.right;
            }
            else{
                TreeNode rmc=rightMostChild(root,ll);
                
                if(rmc.right==null){
                    rmc.right=root;
                    root=root.left;
                }
                else{
                    rmc.right=null;
                    temp=root;
                    root=root.right;
                }
            }
            
            if(temp!=null){
                if(prev!=null && prev.val>temp.val){
                    if(a==null) a=prev;
                    b=temp;
                }
                prev=temp;
            }
        }
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
    }
     TreeNode rightMostChild(TreeNode curr,TreeNode left){
        while(left.right!=null && left.right!=curr) left=left.right;
        return left;
    }
}