/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution
{
    static int length(ListNode n)
    {
        int count=0;
        while(n!=null)
        {
            count++;
            n=n.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if(headA==null || headB==null) return null;
        int l1= length(headA);
        int l2=length(headB);
        if(l2>l1)
        {
            int l=l1;
            l1=l2;
            l2=l;
            ListNode a=headA;
            headA=headB;
            headB=a;
        }
        for(int i=0;i<(l1-l2);i++)
            headA=headA.next;
        while(headA!=null && headB!=null)
        {
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return  null;
    }
}