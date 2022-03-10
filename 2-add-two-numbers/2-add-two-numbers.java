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
    ListNode reverse(ListNode curr)
    {
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode temp=new ListNode(-1),tail=temp;
        int c=0;
        while(l1!=null || l2!=null)
        {
            int num=c + (l1==null?0:l1.val) + (l2==null?0:l2.val);
            tail.next=l1==null?l2:l1;
            tail=tail.next;
            l1=l1==null?l1:l1.next;
            l2=l2==null?l2:l2.next;
            tail.val=num%10;
            c=num/10;
        }
        if(c!=0) tail.next=new ListNode(c);
        return temp.next;
    }
}