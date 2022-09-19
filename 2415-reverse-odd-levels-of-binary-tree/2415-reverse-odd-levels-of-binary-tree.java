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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        
        boolean ok=false;
        while(!q.isEmpty()){
            
            int size=q.size();
            List<TreeNode> list=new ArrayList<>();
            while(size-->0){
                
                TreeNode node=q.remove();
                if(ok) list.add(node);
                
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                
            }
            
            int s=0,e=list.size()-1;
            while(s<e){
                
                int num=list.get(s).val;
                list.get(s).val=list.get(e).val;
                list.get(e).val=num;
                s++;
                e--;
            }
            
            ok=!ok;
        }
        return root;
    }
}