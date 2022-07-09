# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1 or not list2:
            return list1 or list2 or None
        
        head, current, nextNode = None, None, None
        p1, p2 = list1, list2
        while p1 or p2:
            if p1 and p2:
                nextNode = p1 if p1.val < p2.val else p2
            else:
                nextNode = p1 or p2
            
            if nextNode == p1:
                p1 = p1.next
            else:
                p2 = p2.next
                
            if current:
                current.next = nextNode
                current = nextNode
            else:
                current = nextNode
                head = nextNode
        
        return head
        
                