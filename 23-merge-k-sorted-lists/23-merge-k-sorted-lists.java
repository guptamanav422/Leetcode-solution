/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists)
    {
       ListNode head=new ListNode(-1),tail=head;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((ListNode a,ListNode b)->(a.val-b.val));
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            pq.add(lists[i]);
        }
        while(!pq.isEmpty())
        {
            ListNode temp=pq.remove();
            tail.next=temp;
            tail=tail.next;
            if(temp.next!=null) pq.add(temp.next);
        }
        return head.next;
    }
}