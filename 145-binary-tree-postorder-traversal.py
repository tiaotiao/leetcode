
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    class WaitingNode:
        def __init__(self, val):
            self.val = val
            self.count = 0
    
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []

        stack = [root]      # tree nodes to be visited
        waiting = []        # stack waiting for being output
        output = []         # output list

        while len(stack) > 0:
            # pop out a node to visit
            node = stack.pop()
            w = Solution.WaitingNode(node.val)
            
            # extend its children
            if node.right:
                stack.append(node.right)
                w.count += 1
            if node.left:
                stack.append(node.left)
                w.count += 1

            # push current node to waiting stack
            waiting.append(w)

            # pop out from waiting stack to output list
            # if its count == 0 (dependence)
            while len(waiting) > 0:
                if waiting[-1].count > 0:
                    break
                w = waiting.pop()
                output.append(w.val)
                if len(waiting) > 0:
                    waiting[-1].count -= 1
        return output



