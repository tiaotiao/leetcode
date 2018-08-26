

# Definition for a undirected graph node
class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        return self.clone(node, {})

    def clone(self, node, m):
        if node == None:
            return None
        
        if node.label in m:
            return m[node.label]
 
        p = UndirectedGraphNode(node.label)

        m[node.label] = p

        for q in node.neighbors:
            p.neighbors.append(self.clone(q, m))

        return p