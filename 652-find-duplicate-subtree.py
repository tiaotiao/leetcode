
class Solution:
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        m = {}
        self.travseral(root, m)
        return [v for k, v in m.items() if v is not None]
        
    def travseral(self, node, m):
        if node == None:
            return ""
        
        l = self.travseral(node.left, m)
        r = self.travseral(node.right, m)
        
        s = "{},{},{}".format(l, r, node.val)

        if s not in m:
            m[s] = None
        else:
            m[s] = node
        return s