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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode oddTail = null, evenHead = null, evenTail = null;
        ListNode current = head;
        int counter = 1;
        while (current != null) {
            if (counter % 2 == 0) {
                if (evenTail == null) {
                    evenHead = current;
                } else {
                    evenTail.next = current;
                }
                evenTail = current;
            } else {
                if (oddTail != null) {
                    oddTail.next = current;
                }
                oddTail = current;
            }
            
            current = current.next;
            counter++;
        }
        
        oddTail.next = evenHead;
        evenTail.next = null;
        return head;
    }
}