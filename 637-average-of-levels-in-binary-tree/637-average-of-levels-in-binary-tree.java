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
class Solution
{
    public void check(Map<Integer,long []> map,TreeNode root,int l)
    {
        if(root==null) return;
        if(!map.containsKey(l)) map.put(l,new long[]{1,root.val});
        else
        {
            long arr[]=map.get(l);
            arr[0]++;
            arr[1]+=root.val;
        }
        check(map,root.left,l+1);
        check(map,root.right,l+1);
    }
    public List<Double> averageOfLevels(TreeNode root)
    {
        if(root==null) return new ArrayList<>();
        Map<Integer,long []> map=new TreeMap<>();
        check(map,root,0);
        List<Double> list=new ArrayList<>();
        for(Map.Entry<Integer,long []> entry:map.entrySet())
        {
            long arr[]=entry.getValue();
            list.add((double)arr[1]/arr[0]);
        }
        return list;
    }
}