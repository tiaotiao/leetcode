

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None: return 0
        
        # the height of leftmost branch
        left = self.leftmost(root)

        # the height of rightmost branch
        right = self.rightmost(root)

        if left == right:
            # it is a full binary tree
            size = 2 ** (left + 1) - 1
            return size

        leftSize = self.countNodes(root.left)

        rightSize = self.countNodes(root.right)

        return leftSize + rightSize + 1

    def leftmost(self, node):
        if not node: return 0
        left = 0
        while node.left:
            node = node.left
            left += 1
        return left

    def rightmost(self, node):
        if not node: return 0
        right = 0
        node = node
        while node.right:
            node = node.right
            right += 1
        return right
