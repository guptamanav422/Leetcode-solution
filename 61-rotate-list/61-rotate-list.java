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
    public ListNode rotateRight(ListNode head, int k)
    {
        if(head==null || head.next==null) return head;
        ListNode n=head,tail=null;
        int l=0;
        while(n!=null)
        {
            l++;
            if(n.next==null) tail=n;
            n=n.next;
        }
        k=k%l;
        if(k==0) return head;
        k++;
        k=l-k;
        n=head;
        while(k>0)
        {
            k--;
            n=n.next;
        }
        ListNode m=n.next;
        n.next=null;
        tail.next=head;
        return m;
    }
}