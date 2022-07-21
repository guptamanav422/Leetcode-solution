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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr=head,pre=null;
        int num=1;
        while(num<left)
        {
            pre=curr;
            curr=curr.next;
            num++;
        }
        ListNode next=null,prev=null,a=curr;
        while(curr!=null && right>=num){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            num++;
        }
        // System.out.println(a.val);
        if(pre!=null){
            pre.next=prev;
        }
        a.next=next;
        return pre==null?prev:head;
    }
}