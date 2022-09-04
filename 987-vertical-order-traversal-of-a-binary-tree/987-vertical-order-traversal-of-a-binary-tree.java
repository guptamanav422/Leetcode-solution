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
    public class pair implements Comparable<pair>{
        
        int width,height;
        TreeNode root;
        
        pair(int a,int b,TreeNode c){
            width=a;
            height=b;
            root=c;
        }
        
        public int compareTo(pair b){
            
            if(this.height!=b.height) return this.height-b.height;
            else if(this.width!=b.width) return this.width-b.width;
            else return this.root.val-b.root.val;
        }
    }
    List<List<Integer>> ans1=new ArrayList<>();
    List<List<Integer>> ans2=new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        PriorityQueue<pair> q=new PriorityQueue<>();
        q.add(new pair(0,0,root));
        
        while(!q.isEmpty()){
            
            pair temp=q.remove();
            int col=temp.width,row=temp.height;
            TreeNode curr=temp.root;
            
            if(col<0){
                int c=Math.abs(col)-1;
                if(c==ans1.size()) ans1.add(new ArrayList<>());
                ans1.get(c).add(curr.val);
            }
            else{
                if(col==ans2.size()) ans2.add(new ArrayList<>());
                ans2.get(col).add(curr.val);
            }
            
            if(curr.left!=null) q.add(new pair(col-1,row+1,curr.left));
            if(curr.right!=null) q.add(new pair(col+1,row+1,curr.right));
        }
        Collections.reverse(ans1);
        ans1.addAll(ans2);
        return ans1;
    }
}