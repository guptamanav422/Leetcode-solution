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
    public int pseudoPalindromicPaths (TreeNode root) {
        int ans[]=new int[1];
        find(root,new int[10],ans);
        return ans[0];
    }
    void find(TreeNode root,int arr[],int ans[]){
        if(root==null) return;
        
        if(root.left==null && root.right==null){
            int s=1,ok=0;
            arr[root.val]++;
            while(s<=9 && ok<2){
                if(arr[s]%2!=0) ok++;
                s++;
            }
            if(ok<2) ans[0]++;
            arr[root.val]--;
            return;
        }
        
        arr[root.val]++;
        find(root.left,arr,ans);
        find(root.right,arr,ans);
        arr[root.val]--;
    }
}