/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node)
    {
        if(node==null) return null;
        Map<Integer,Node> map=new HashMap<>();
        map.put(node.val,new Node(node.val));
        clone(map,node,map.get(node.val));
        return map.get(node.val);
    }
    void clone(Map<Integer,Node> map,Node node,Node root)
    {
        for(Node n1:node.neighbors)
        {
            if(map.containsKey(n1.val))
            {
                root.neighbors.add(map.get(n1.val));
            }
            else
            {
                Node a=new Node(n1.val);
                map.put(n1.val,a);
                root.neighbors.add(a);
                clone(map,n1,a);
            }
        }
    }
}