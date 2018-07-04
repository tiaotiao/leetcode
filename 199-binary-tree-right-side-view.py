
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        
        if not root:
            return []

        rightView = []
        currLevel = [root]
        nextLevel = []

        while len(currLevel) > 0:
            rightView.append(currLevel[0].val)

            for node in currLevel:
                if node.right:
                    nextLevel.append(node.right)
                if node.left:
                    nextLevel.append(node.left) 
            
            currLevel = nextLevel
            nextLevel = []

        return rightView

