/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head)
    {
        if(head==null) return null;
        Node temp=head;
        while(temp!=null)
        {
            Node n=temp.next;
            temp.next=new Node(temp.val);
            temp.next.next=n;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null)
        {
            temp.next.random=temp.random==null?null:temp.random.next;
            temp=temp.next.next;
        }
        temp=head;
        Node ans=temp.next;
        while(temp!=null)
        {
            Node n=temp.next.next;
            temp.next.next=n==null?null:n.next;
            temp.next=n;
            temp=n;
        }
        return ans;
    }
}