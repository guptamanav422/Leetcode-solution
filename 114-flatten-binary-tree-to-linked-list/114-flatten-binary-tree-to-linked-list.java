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
        TreeNode head,tail;
        pair(TreeNode a,TreeNode b)
        {
            head=a;
            tail=b;
        }
    }
    public void flatten(TreeNode root) {
        find(root);
    }
    pair find(TreeNode root)
    {
        if(root==null) return new pair(null,null);
        pair left=find(root.left);
        pair right=find(root.right);
        
        pair ans;
        root.left=null;
        if(left.tail==null && right.tail==null)
        {
            ans=new pair(root,root);
        }
        else if(left.tail==null)
        {
            root.right=right.head;
            ans=new pair(root,right.tail);
        }
        else if(right.tail==null)
        {
            root.right=left.head;
            ans=new pair(root,left.tail);
        }
        else{
            root.right=left.head;
            left.tail.right=right.head;
            ans=new pair(root,right.tail);
        }
        return ans;
    }
}