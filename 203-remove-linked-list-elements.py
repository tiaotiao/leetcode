# Remove all elements from a linked list of integers that have value val.

# Example:

# Input:  1->2->6->3->4->5->6, val = 6
# Output: 1->2->3->4->5


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(None)
        dummy.next = head

        prev = dummy
        node = head

        while node != None:
            next = node.next
            if node.val == val:
                prev.next = node.next
                del node
                node = next
                continue
            
            prev = node
            node = next

        return dummy.next 

        