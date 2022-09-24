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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        List<List<Integer>> ans=new ArrayList<>();
        path(root,ans,targetSum,new ArrayList<>());
        return ans;
    }
    void path(TreeNode root,List<List<Integer>> ans,int tar,List<Integer> list)
    {
        if(root!=null)
        tar-=root.val;
        if(root==null) return;
        if(root.left==null && root.right==null && tar==0)
        {
            list.add(root.val);
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        path(root.left,ans,tar,list);
        path(root.right,ans,tar,list);
        list.remove(list.size()-1);
    }
}