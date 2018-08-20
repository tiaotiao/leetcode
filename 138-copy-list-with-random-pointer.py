
# Definition for singly-linked list with a random pointer.
class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None



class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """

        return self.copy(head)

    def copy(self, node, idx=0, m={}):
        if node is None:
            return None
        
        p = RandomListNode(node.label)
        m[idx] = p

        node.idx = idx      # additional index

        p.next = self.copy(node.next, idx + 1, m)
        
        if node.random is None:
            p.random = None
        else:
            rand = node.random
            i = rand.idx
            p.random = m[i]

        return p