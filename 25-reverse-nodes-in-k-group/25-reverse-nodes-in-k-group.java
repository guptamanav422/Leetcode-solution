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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        int n=k;
        ListNode curr=head,next=null,prev=null;
        while(n-->0 && curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // if(next!=null)
        // System.out.println(n);
        // prev.next=null;
        if(n==-1){
            // System.out.println(prev.val);
            head.next=reverseKGroup(next,k);
            return prev;
        }
        else{
            curr=prev;
            next=null;
            prev=null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
        }
        return head;
    }
}