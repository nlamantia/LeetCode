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
        ListNode beforeLeft = null, current = head;
        for (int i = 1; i < right; i++) {
            if (i == left - 1) {
                beforeLeft = current;
            }
            current = current.next;
        }
        ListNode afterRight = current.next;
        
        current = beforeLeft == null ? head : beforeLeft.next;
        ListNode prev = afterRight;
        while (current != afterRight) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        if (left > 1) {
            beforeLeft.next = prev;
            return head;
        } else {
            return prev;
        }
        
    }
}