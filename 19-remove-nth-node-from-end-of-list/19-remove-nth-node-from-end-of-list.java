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
    // O(n) time | O(1) space
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // count number of nodes - O(n) where n is the length of the list
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        
        // find node *before* length of list - n from the beginning - O(n) 
        current = null;
        for (int i = 0; i < size - n; i++) {
            current = i == 0 ? head : current.next;
        }
        
        // remove node - O(1)
        if (current == null) {
            return head.next;
        } else {
            current.next = current.next.next;
        }
        
        return head;
    }
}