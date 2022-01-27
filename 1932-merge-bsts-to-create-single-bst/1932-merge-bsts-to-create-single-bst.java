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
    public TreeNode canMerge(List<TreeNode> trees) {
        
        if(trees.size()==1) return trees.get(0);
        Map<Integer,Integer> cnt= new HashMap<>();
        Map<Integer,TreeNode> map=new HashMap<>();
        
        for(TreeNode root:trees){
            
            map.put(root.val,root);
            
            cnt.put(root.val,cnt.getOrDefault(root.val,0)+1);
            if(root.left!=null){
                cnt.put(root.left.val,cnt.getOrDefault(root.left.val,0)+1);
            }
            if(root.right!=null){
                cnt.put(root.right.val,cnt.getOrDefault(root.right.val,0)+1);
            }
        }
        
        for(int a:cnt.keySet()){
            if(cnt.get(a)==1 && map.containsKey(a)){
                // System.out.println(a);
                return (find(map.get(a),map,Integer.MAX_VALUE,Integer.MIN_VALUE) && map.size()==1)?map.get(a):null;
            }
        }
        return null;
    }
    boolean find(TreeNode root,Map<Integer,TreeNode> map,int max,int min){
        if(root==null) return true;
        
        if(root.val>=max || root.val<=min){
            // System.out.println(root.val);
            return false;
        }
        
        if(root.left==root.right && map.containsKey(root.val)){
            
            TreeNode temp=map.get(root.val);
            root.left=temp.left;
            root.right=temp.right;
            map.remove(root.val);
        }
        
        return find(root.left,map,root.val,min) && find(root.right,map,max,root.val);
    }
}