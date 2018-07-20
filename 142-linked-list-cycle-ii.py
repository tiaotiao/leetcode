

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        node = self.has_cycle(head)
        if node is None:
            return None
        
        n = self.count_cycle(node)

        return self.detect(head, n)

    def detect(self, head, n):
        fast = self.step(head, n)
        slow = head

        while True:
            if fast == slow:
                return slow
            fast = fast.next
            slow = slow.next
        
    def has_cycle(self, head):
        fast, slow = head, head
        while True:
            fast = self.step(fast, 2)
            slow = self.step(slow, 1)
            if fast == None or slow == None:
                break
            if fast == slow:
                return fast
        return None

    def count_cycle(self, node):
        p = node
        n = 1
        while True:
            p = p.next
            if p == node:
                return n
            n += 1

    def step(self, node, k):
        for _ in range(k):
            if node == None:
                return None
            node = node.next
        return node