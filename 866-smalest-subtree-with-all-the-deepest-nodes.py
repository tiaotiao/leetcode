

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def subtreeWithAllDeepest(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.maxDepth = 0
        self.deepest = 0
        self.subtree = None

        self.depth(root, 0)

        return self.subtree

        
    def depth(self, node, d):
        if node is None:
            return d

        d += 1
        if d > self.maxDepth:
            self.maxDepth = d
            self.deepest = 0
            self.subtree = None
        
        leftDepth = self.depth(node.left, d)
        
        rightDepth = self.depth(node.right, d)

        if leftDepth == self.maxDepth and rightDepth == self.maxDepth:
            self.subtree = node
        
        return max(leftDepth, rightDepth)
