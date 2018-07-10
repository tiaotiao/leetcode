
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        if root == None:
            return 0

        _, total = self.traversal(root, sum)
        return total
        
    def traversal(self, node, sum):
        """return collection of all possible sums we can get of the subtree from this node"""

        sums = {node.val: 1}
        total = 0

        if node.left:
            left, count = self.traversal(node.left, sum)
            self.addUp(node.val, sums, left)
            total += count
        if node.right:
            right, count = self.traversal(node.right, sum)
            self.addUp(node.val, sums, right)
            total += count
        
        if sum in sums:
            total += sums[sum]
        
        return sums, total

    def addUp(self, val, s, t):
        for v in t:
            count = t[v]
            k = v + val
            if k not in s:
                s[k] = count
            else:
                s[k] += count

