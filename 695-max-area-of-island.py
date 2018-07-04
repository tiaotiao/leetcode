

class Solution(object):
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        if n <= 0: return 0
        m = len(grid[0])
        if m <= 0: return 0
        
        mx = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    # print("fill", i, j)
                    area = self.fill(grid, n, m, i, j)
                    mx = max(mx, area)
        return mx
        

    def fill(self, grid, n, m, x, y):
        dirs = ((0, 1), (1, 0), (-1, 0), (0, -1))

        idx = 0
        queue = [(x, y)]
        grid[x][y] = 0
        area = 0

        while idx < len(queue):
            point = queue[idx]
            idx += 1
            i = point[0]
            j = point[1]
            area += 1

            for d in dirs:
                x = i + d[0]
                y = j + d[1]

                if x < 0 or n <= x: continue
                if y < 0 or m <= y: continue
                if grid[x][y] != 1: continue

                grid[x][y] = 0
                queue.append((x, y))

        return area

def main():
    s = Solution()
    grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
    print(s.maxAreaOfIsland(grid))

if __name__ == '__main__':
    main()