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
    List<List<Integer>> list=new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        find(root,0);
        return list;
    }
    void find(TreeNode root,int l){
        
        if(root==null) return;
        if(list.size()==l) list.add(0,new LinkedList<>());
        
        list.get(list.size()-1-l).add(root.val);
        find(root.left,l+1);
        find(root.right,l+1);
    }
}