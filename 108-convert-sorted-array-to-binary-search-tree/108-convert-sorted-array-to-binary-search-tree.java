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
    public TreeNode sortedArrayToBST(int[] nums)
    {
        return create(nums,0,nums.length-1);
    }
    TreeNode create(int arr[],int s,int e)
    {
        if(s>e) return null;
        int m=(s+e)/2;
        TreeNode node=new TreeNode(arr[m]);
        node.left=create(arr,s,m-1);
        node.right=create(arr,m+1,e);
        return node;
    }
}