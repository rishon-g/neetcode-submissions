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

// key idea: because we want to return an updated list, we keep a dummy node at the start and a
// tail node we use to keep on updating.

// if both lists are not null, we compare the values of each list and compare. we set tail to be 
// the smaller of the 2 and iterate (tail = tail.next) we keep doing this until any list is null.

// if one list is null, there's a chance the other isn't, so we have a final check in the end
// where the non-null list is the remainder of our list 

// finally, we return dummy.next, the start of our list.

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tail = new ListNode(0);
        ListNode dummy = tail;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                tail.next = list2;
                list2 = list2.next;
            }
            else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next;
        
    }
}