# https://leetcode.com/problems/cut-off-trees-for-golf-event/description/

# You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

# 0 represents the obstacle can't be reached.
# 1 represents the ground can be walked through.
# The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
# You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

# You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

# You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

# Example 1:
# Input: 
# [
#  [1,2,3],
#  [0,0,4],
#  [7,6,5]
# ]
# Output: 6
# Example 2:
# Input: 
# [
#  [1,2,3],
#  [0,0,0],
#  [7,6,5]
# ]
# Output: -1

from collections import deque

class Solution:
    def cutOffTree(self, forest):
        """
        :type forest: List[List[int]]
        :rtype: int
        """
        self.n = len(forest)
        if self.n == 0: return -1
        self.m = len(forest[0])
        if self.m == 0: return -1

        trees = []
        for row in forest:
            for tree in row:
                if tree == 0 or tree == 1:
                    continue
                trees.append(tree)

        trees.sort()

        total = 0
        x, y = (0, 0)
        for tree in trees:
            (x, y), steps = self.search(forest, x, y, tree)
            if steps == -1:
                return -1
            total += steps
        return total
        
    def search(self, forest, x, y, tree):
        # return (treeX, treeY) and steps
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]

        queue = deque()
        queue.append((x, y))
        visited = [[-1 for j in range(self.m)] for i in range(self.n)]
        visited[x][y] = 0

        while len(queue) > 0:
            x, y = queue.popleft()
            steps = visited[x][y]
            if forest[x][y] == tree:
                return (x, y), steps

            for d in dirs:
                i = x + d[0]
                j = y + d[1]
                if i < 0 or self.n <= i:
                    continue
                if j < 0 or self.m <= j:
                    continue
                if forest[i][j] == 0: continue
                if visited[i][j] >= 0: continue
                
                if forest[i][j] == tree:
                    return (i, j), steps + 1

                visited[i][j] = steps + 1
                queue.append((i, j))
        return (0,0), -1

def main():
    s = Solution()
    # f = [
    #     [1,2,3],
    #     [0,0,4],
    #     [7,6,5]
    # ]
    f = [[2,3,4],[0,0,5],[8,7,6]]

    print(s.cutOffTree(f))


if __name__ == '__main__':
    main()

