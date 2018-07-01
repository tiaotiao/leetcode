

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def distanceK(self, root, target, K):
        """
        :type root: TreeNode
        :type target: TreeNode
        :type K: int
        :rtype: List[int]
        """
        path = []
        ok = self.findTarget(root, target, path)
        if not ok:
            return None

        results = []
        self.findDistanceK(root, [], path, K, results)
        
        return results

    def findDistanceK(self, node, path, targetPath, K, results):
        if node == None:
            return

        if self.distance(path, targetPath) == K:
            results.append(node.val)
        
        path.append('left')
        self.findDistanceK(node.left, path, targetPath, K, results)
        path.pop()
        path.append('right')
        self.findDistanceK(node.right, path, targetPath, K, results)
        path.pop()

    def distance(self, path, targetPath):
        lenPath = len(path)
        lenTarget = len(targetPath)
        for i in range(min(lenPath, lenTarget)):
            if path[i] != targetPath[i]:
                return (lenPath - i) + (lenTarget - i)
        return abs(lenPath - lenTarget)

    def findTarget(self, node, target, path):
        if node == None:
            return False
        if node.val == target.val:
            return True

        path.append('left')
        if self.findTarget(node.left, target, path):
            return True
        path.pop()
        path.append('right')
        if self.findTarget(node.right, target, path):
            return True
        path.pop()
        return False

