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
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            curr = curr.next;
            length++;
        }

        int removal = length - n;
        if (removal == 0) {
            return head.next;
        }

        int i = 0;
        curr = head;
        while (curr != null) {
            if (i + 1 == removal) {
                curr.next = curr.next.next;
                break;
            }
            i++;
            curr = curr.next;
        }

        return head;
    }
}
