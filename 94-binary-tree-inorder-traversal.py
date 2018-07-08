
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        stack = []
        output = []

        node = root
        while True:
            while node:
                stack.append(node)
                node = node.left
            if len(stack) == 0:
                break
            node = stack.pop()
            output.append(node.val)
            
            node = node.right

        return output
