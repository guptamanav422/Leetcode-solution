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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        while(temp!=null && n-->0) temp=temp.next;
        if(temp==null) return head.next;
        
        ListNode ab=head;
        while(temp.next!=null){
            temp=temp.next;
            ab=ab.next;
        }
        ab.next=ab.next.next;
        return head;
    }
}