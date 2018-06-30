# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        
        prev = node
        curr = node.next
        while True:
            prev.val = curr.val
            if curr.next == None:
                prev.next = None
                break
            prev = curr
            curr = curr.next


