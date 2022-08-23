/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<TreeNode> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        find(root,ans,target);
        // for(TreeNode a:ans){
        //     System.out.print(a.val+" ");
        // }
        dfs(target,k,res);
        for(int i=ans.size()-1;i>=0;i--){
            k--;
            if(k==0) res.add(ans.get(i).val);
            else{
                if(ans.get(i).left==target) dfs(ans.get(i).right,k-1,res);
                else dfs(ans.get(i).left,k-1,res);
            }
            target=ans.get(i);
        }
        return res;
    }
    void dfs(TreeNode root,int k,List<Integer> res){
        if(k<0 || root==null) return;
        // System.out.println(root.val+" "+k);
        if(k==0){
            res.add(root.val);
            return;
        }
        dfs(root.left,k-1,res);
        dfs(root.right,k-1,res);
    }
    boolean find(TreeNode root,List<TreeNode> ans,TreeNode target){
        
        if(root==null) return false;
        if(root==target) return true;
        ans.add(root);
        boolean ok=find(root.left,ans,target) || find(root.right,ans,target);
        
        if(!ok) ans.remove(ans.size()-1);
        return ok;
    }
}