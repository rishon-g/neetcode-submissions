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

 // Key idea: Split the list in half, reverse the second half, and weave the two halves together in place.
// 1. Find middle: Start fast = head.next so slow lands at the end of the first half (first half is >= second half).
//    Save second = slow.next and cut with slow.next = null to prevent cycles.
// 2. Reverse second half: Standard in-place reversal (prev, curr, next) so we can pull nodes from the back in O(1) space.
// 3. Weave: Alternate nodes (first -> second -> next1) while (second != null), since second is always the same length or 1 node shorter than first. Any leftover node in first is already linked at the end.
// Time complexity: O(n) | Space complexity: O(1)

class Solution {
    public void reorderList(ListNode head) {
        // find middle with slow & fast (e.g., if we get to 10 nodes, fast will get there 2x faster than slow, so we know slow is half of fast.)
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // cut list in half
        ListNode second = slow.next;
        slow.next = null;

        // reverse second half
        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // weave two halves together

        ListNode first = head;
        second = prev; // head of reversed list

        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }


    }
}
