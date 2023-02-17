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
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head, prev = null, newHead = null;
        while (current != null) {
            if (current.val == val && prev != null) {
                prev.next = current.next;
            } else if (current.val != val) {
                prev = current;
                if (newHead == null) {
                    newHead = current;
                }
            }
            current = current.next;
        }
        return newHead;
    }
}