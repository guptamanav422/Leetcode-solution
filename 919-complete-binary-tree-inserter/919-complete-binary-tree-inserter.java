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
class CBTInserter {

    TreeNode root;
    Queue<TreeNode> q=new LinkedList<>();
    public CBTInserter(TreeNode root) {
        q.add(root);
        
        while(!q.isEmpty()){
            
            if(q.peek().left!=null) q.add(q.peek().left);
            else break;
            if(q.peek().right!=null){
                q.add(q.peek().right);
                q.remove();
            }
            else break;
        }
        this.root=root;
    }
    
    public int insert(int val) {
        
        TreeNode ans=q.peek();
        // System.out.println(ans.val+" "+val);
        if(q.peek().left==null){
            // System.out.println(val);
            q.peek().left=new TreeNode(val);
            q.add(q.peek().left);
        }
        else{
            q.peek().right=new TreeNode(val);
            q.add(q.peek().right);
            q.remove();
        }
        return ans.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */