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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(n -> n.val));
        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }
        
        ListNode head = null, current = null;
        while (!heap.isEmpty()) {
            ListNode next = heap.poll();
            if (current == null) {
                current = next;
                head = next;
            } else {
                current.next = next;
                current = next;
            }
            
            int listIndex = memberOf(lists, current);
            lists[listIndex] = lists[listIndex].next;
            if (lists[listIndex] != null) {
                heap.offer(lists[listIndex]);
            }
        }
        
        return head;
    }
    
    private int memberOf(ListNode[] lists, ListNode node) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == node) {
                return i;
            }
        }
        return -1;
    }
}