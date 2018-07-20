

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """

        fast, slow = head, head

        while True:
            slow = self.next(slow)
            fast = self.next(self.next(fast))
            if fast == None or slow == None:
                break
            if fast == slow:
                return True
        return False

    def next(self, node):
        if node == None:
            return None
        return node.next