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
    public boolean isPalindrome(ListNode head) {
        // find middle
        ListNode middle = head, end = head;
        while (end != null && end.next != null) {
            middle = middle.next;
            end = end.next.next;
        }
        
        // reverse from middle to end
        end = reverse(middle);
        
        // start on outer edges and work way inward to middle
        ListNode start = head;
        while (start != null && end != null) {
            if (start.val != end.val) return false;
            start = start.next;
            end = end.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode current = head, prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}