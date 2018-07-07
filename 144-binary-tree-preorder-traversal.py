
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        
        if root == None:
            return []
            
        stack = [root]
        output = []

        while len(stack) > 0:
            node = stack.pop()
            
            output.append(node.val)

            if node.right:
                stack.append(node.right)
            if node.left: 
                stack.append(node.left)
        return output
