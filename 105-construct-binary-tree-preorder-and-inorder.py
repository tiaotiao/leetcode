
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        if len(preorder) != len(inorder):
            return None
        
        node = TreeNode(preorder[0])
        idx = inorder.index(preorder[0])

        node.left = self.buildTree(preorder[1:1+idx], inorder[0:idx])
        node.right = self.buildTree(preorder[1+idx:], inorder[1+idx:])

        return node
