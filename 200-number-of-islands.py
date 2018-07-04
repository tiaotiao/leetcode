
class Solution:
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        n = len(grid)
        if n <= 0: return 0
        m = len(grid[0])
        if m <= 0: return 0

        count = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    count += 1
                    self.fill(grid, i, j, n, m)

        return count

    def fill(self, grid, i, j, n, m):
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        idx = 0
        queue = [(i, j)]
        while idx < len(queue):
            curr = queue[idx]
            idx += 1
            i = curr[0]
            j = curr[1]

            for d in dirs:
                x = i + d[0]
                y = j + d[1]
                if x < 0 or n <= x or y < 0 or m <= y:
                    continue
                if grid[x][y] != "1":
                    continue
                
                queue.append((x, y))

                grid[x][y] = "0"

        

def main():
    s = Solution()

    grid = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]

    print(s.numIslands(grid))

if __name__ == '__main__':
    main()