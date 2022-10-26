/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        Set<ListNode> visited = new HashSet<>();
        while (a != null || b != null) {
            if (a != null) {
                if (visited.contains(a)) return a;
                visited.add(a);
                a = a.next;
            }
            
            if (b != null) {
                if (visited.contains(b)) return b;
                visited.add(b);
                b = b.next;
            }
        }
        return null;
    }
}