

class Solution:
    def largestIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        self.dirs = [(0,1), (1,0), (-1,0), (0,-1)]

        self.n = len(grid)
        if self.n == 0: return 0
        self.m = len(grid[0])
        if self.m == 0: return 0

        islands = self.repaint(grid)
        if len(islands) == 0:
            return 1

        return self.connect(grid, islands)

    def repaint(self, grid):
        color = 2
        islands = {}

        for i in range(self.n):
            for j in range(self.m):
                if grid[i][j] != 1: continue
                size = self.paint(grid, i, j, color)
                islands[color] = size
                color += 1
        return islands

    def paint(self, grid, x, y, color):
        queue = [(x,y)]
        grid[x][y] = color
        size = 1
        while len(queue) > 0:
            x, y = queue.pop()
            for d in self.dirs:
                i, j = x + d[0], y + d[1]
                if i < 0 or self.n <= i: continue
                if j < 0 or self.m <= j: continue
                if grid[i][j] != 1: continue
                
                grid[i][j] = color
                size += 1
                queue.append((i, j))
        return size

    def connect(self, grid, islands):
        maximum = max(islands.values())

        # print("islands", islands, grid)
        for i in range(self.n):
            for j in range(self.m):
                if grid[i][j] != 0: continue
                
                neighbors = self.neighbors(grid, i, j)
                size = 1
                for color in neighbors:
                    size += islands[color]

                # print(i, j, neighbors, size)
                if maximum < size:
                    maximum = size

        return maximum

    def neighbors(self, grid, x, y):
        neighbor = set()

        for d in self.dirs:
            i, j = x + d[0], y + d[1]
            if i < 0 or self.n <= i: continue
            if j < 0 or self.m <= j: continue
            color = grid[i][j]
            if color == 0: continue
            neighbor.add(color)

        return neighbor


def main():
    s = Solution()

    tests = [
        [[1,0],[0,1]],
        [[1,1],[1,0]],
        [[1,1],[1,1]],
        [[0,1,1],
         [1,0,1],
         [0,1,0]]
    ]

    for t in tests:
        print(s.largestIsland(t))

if __name__ == '__main__':
    main()