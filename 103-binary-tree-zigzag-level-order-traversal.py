

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root == None:
            return []

        levels = self.levelTraversal(root)

        for i in range(1, len(levels), 2):
            levels[i].reverse()
        
        results = self.toNumbers(levels)
        print(results)
        return results

    def toNumbers(self, levels):
        results = []
        for level in levels:
            r = []
            for node in level:
                r.append(node.val)
            results.append(r)
        return results

    def levelTraversal(self, root):
        levels = []
        
        levels.append([root])

        index = 0
        while index < len(levels):
            level = levels[index]
            nextLevel = []

            for node in level:
                if node.left != None:
                    nextLevel.append(node.left)
                if node.right != None:
                    nextLevel.append(node.right)

            if len(nextLevel) > 0:
                levels.append(nextLevel)
            index += 1
        
        return levels

        