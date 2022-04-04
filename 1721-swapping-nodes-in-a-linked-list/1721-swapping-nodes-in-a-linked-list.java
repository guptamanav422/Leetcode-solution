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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode a=head,b=head,curr=head,te=head;
        while(k-->1){
            a=a.next;
        }
        curr=a;
        while(curr.next!=null){
            curr=curr.next;
            b=b.next;
        }
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
        return te;
    }
}