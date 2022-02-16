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
    public ListNode swapPairs(ListNode head) {
        
        
        if(head==null || head.next==null) return head;
        
        ListNode next=head.next.next;
        ListNode n=head.next;
        n.next=head;
        head.next=swapPairs(next);
        return n;
    }
}