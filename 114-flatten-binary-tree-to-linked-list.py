

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        self.convert(root)
        
    def convert(self, node):
        """
        return 'tail' of converted list
        """

        if not node:
            return None

        left = node.left
        right = node.right

        leftTail = self.convert(left)
        rightTail = self.convert(right)

        node.left = None
        if leftTail:
            node.right = left
            leftTail.right = right

        if rightTail:
            return rightTail
        if leftTail:
            return leftTail
        return node
        