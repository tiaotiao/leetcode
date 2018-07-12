


# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root == None:
            return []

        levels = [[root]]
        result = []

        i = 0
        while i < len(levels):
            currLevel = levels[i]
            nextLevel = []
            res = []

            for node in currLevel:
                res.append(node.val)
                for ch in node.children:
                    nextLevel.append(ch)

            result.append(res)
            if len(nextLevel) > 0:
                levels.append(nextLevel)
            i += 1
            
        return result


        
