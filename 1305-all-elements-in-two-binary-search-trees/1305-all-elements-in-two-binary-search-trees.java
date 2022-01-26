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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> list1=find(root1,new ArrayList<>());
        List<Integer> list2=find(root2,new ArrayList<>());
        
        List<Integer> ans=new ArrayList<>();
        int i=0,j=0,n=list1.size(),m=list2.size();
        while(i<n || j<m){
            
            // System.out.println(i+" "+j);
            if(i==n) ans.add(list2.get(j++));
            else if(j==m) ans.add(list1.get(i++));
            else{
                if(list1.get(i)<=list2.get(j)) ans.add(list1.get(i++));
                else ans.add(list2.get(j++));
            }
        }
        return ans;
    }
    List<Integer> find(TreeNode root,List<Integer> list){
        if(root==null) return list;
        
        find(root.left,list);
        list.add(root.val);
        find(root.right,list);
        return list;
    }
}