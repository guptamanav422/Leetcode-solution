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
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return createTree(preorder,inorder,map,0,inorder.length-1);
    }
    TreeNode createTree(int pre[],int in[],Map<Integer,Integer> map,int s,int e){
        if(s>e) return null;
        
        TreeNode root=new TreeNode(pre[idx]);
        int i=map.get(pre[idx++]);
        
        root.left=createTree(pre,in,map,s,i-1);
        root.right=createTree(pre,in,map,i+1,e);
        return root;
    }
}