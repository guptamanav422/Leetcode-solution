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
    public TreeNode convertBST(TreeNode root)
    {
        TreeNode curr=root;
        int num=0;
        while(curr!=null)
        {
            if(curr.right==null)
            {
                int val=curr.val;
                curr.val+=num;
                num+=val;
                curr=curr.left;
            }
            else
            {
                TreeNode next=curr.right;
                while(next.left!=null && next.left!=curr) 
                    next=next.left;
                if(next.left==null)
                {
                    next.left=curr;
                    curr=curr.right;
                }
                else
                {
                    next.left=null;
                    int val=curr.val;
                    curr.val+=num;
                    num+=val;
                    curr=curr.left;
                }
            }
        }
        return root;
    }
}