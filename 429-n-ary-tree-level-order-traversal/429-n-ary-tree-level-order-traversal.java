/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root)
    {
        List<List<Integer>> list=new ArrayList<>();
        found(root,list,0);
        return list;
    }
    void found(Node root,List<List<Integer>> list,int i)
    {
        if(root==null) return;
        if(list.size()==i) list.add(new ArrayList<>());
        list.get(i).add(root.val);
        for(Node a:root.children)
        {
            found(a,list,i+1);
        }
    }
}