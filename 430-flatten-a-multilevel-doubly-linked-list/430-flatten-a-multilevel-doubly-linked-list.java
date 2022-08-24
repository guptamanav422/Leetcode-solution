/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution
{
    static Node ans(Node head)
    {
        if(head==null) return null;
        Node curr=head,tail=head;
        while(curr!=null){
            
            Node t1=ans(curr.child);
            if(t1!=null){
                Node next=curr.next;
                curr.next=curr.child;
                curr.child.prev=curr;
                curr.child=null;
                tail=t1;
                t1.next=next;
                
                if(next!=null) next.prev=t1;
                curr=next;
            }
            else {
                tail=curr;
                curr=curr.next;
            }
        }
        return tail;
    }
    public Node flatten(Node head)
    {
        if(head==null) return null;
        ans(head);
        return head;
    }
}