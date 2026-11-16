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

 // key idea: curr = head, prev = null. say  we have null->1->2->3->4
 // ListNode next = curr.next.  next = 2
 // curr.next = prev;           curr.next = null
 // prev = curr                 prev = 1
 // curr = next                 curr = 2

 // at the end of this, we have null<-1 2->3->4
 // we do this until the list is fully reversed



class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        return prev;
        
        
    }
}
