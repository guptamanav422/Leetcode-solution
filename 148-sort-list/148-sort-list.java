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

class Solution
{
    static ListNode mid(ListNode head)
    {
        ListNode prev=null;
        while(head!=null && head.next!=null)
        {
          prev=prev==null?head:prev.next;
          head=head.next.next;
        }
        ListNode mid=prev.next;
        prev.next=null;
        return mid;
    }
    static ListNode sort(ListNode left,ListNode right)
    {
        ListNode dummy=new ListNode(),tail=dummy;
        while(left!=null && right!=null)
        {
            if(left.val<right.val)
            {
                tail.next=left;
                left=left.next;
                tail=tail.next;
            }
            else
            {
                tail.next=right;
                right=right.next;
                tail=tail.next;
            }
        }
        tail.next=left==null?right:left;
        return dummy.next;
    }
    public ListNode sortList(ListNode head)
    {
        if(head==null || head.next==null) return head;
        ListNode mid=mid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return sort(left,right);
    }
    
}