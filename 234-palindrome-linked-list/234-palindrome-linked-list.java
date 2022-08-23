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
    public boolean isPalindrome(ListNode head) {
         ListNode p=head;
        Stack<Integer> s=new Stack<>();
        while(p!=null){
            s.push(p.val);
            p=p.next;
        }
        
        ListNode curr=head;
        while(curr!=null){
            int i=s.pop();
                if(i!=curr.val)
                {
                    return false;
                    
                }
            curr=curr.next;
            
            
        }
        return true;
    }
}