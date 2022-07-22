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
    public ListNode partition(ListNode head, int x) {
        ListNode head1=new ListNode(-1),tail1=head1;
        ListNode head2=new ListNode(-1),tail2=head2;
        
        while(head!=null){
            if(head.val<x){
                tail1.next=head;
                tail1=tail1.next;
            }
            else{
                tail2.next=head;
                tail2=tail2.next;
            }
            head=head.next;
        }
        
        tail1.next=head2.next;
        tail2.next=null;
        return head1.next;
    }
}