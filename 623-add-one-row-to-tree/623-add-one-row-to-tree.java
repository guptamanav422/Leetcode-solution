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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth==1){
            TreeNode midRoot=new TreeNode(val);
            midRoot.left=root;
            return midRoot;
        }
        addOneRowUtil(root,val,depth);
        return root;
    }
    void addOneRowUtil(TreeNode root,int val,int depth){
        
        if(root==null) return;
        if(depth==2){
            
            TreeNode tempLeft=root.left;
            root.left=new TreeNode(val);
            root.left.left=tempLeft;
            
            TreeNode tempRight=root.right;
            root.right=new TreeNode(val);
            root.right.right=tempRight;
            
            return;
        }
        
        addOneRowUtil(root.left,val,depth-1);
        addOneRowUtil(root.right,val,depth-1);
    }
}