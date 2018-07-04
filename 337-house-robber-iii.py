
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        yes, no = self.treeRob(root)
        return max(yes, no)

    def treeRob(self, node):
        if not node:
            return 0, 0

        leftYes, leftNo = self.treeRob(node.left)
        rightYes, rightNo = self.treeRob(node.right)

        yes = node.val + leftNo + rightNo
        no = max(leftYes, leftNo) + max(rightYes, rightNo)

        return yes, no
        