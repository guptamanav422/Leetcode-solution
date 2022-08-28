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
    List<TreeNode> ans=new ArrayList<>();
    Set<Integer> set=new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        for(int a:to_delete){
            set.add(a);
        }
        find(root,true);
        return ans;
    }
    TreeNode find(TreeNode root,boolean ok){
        
        if(root==null) return null; 
        
        if(set.contains(root.val)){
            
            find(root.left,true);
            find(root.right,true);
            return null;
        }
        if(ok) ans.add(root);
        
        root.left=find(root.left,false);
        root.right=find(root.right,false);
        
        return root;
    }
}