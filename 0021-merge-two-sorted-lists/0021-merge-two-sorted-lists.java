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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, current = null, next = null;
        while (list1 != null || list2 != null) {
            next = nextNode(list1, list2);
            if (head == null) {
                head = next;
            } else {
                current.next = next;
            }
            
            if (next == list1) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
            
            current = next;
        }
        return head;
    }
    
    private ListNode nextNode(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else return list1.val < list2.val ? list1 : list2;
    }
}