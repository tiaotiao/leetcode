
class Solution:
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """

        n = len(matrix)
        if n == 0: return 0
        m = len(matrix[0])
        if m == 0: return 0
        
        sq = [[0 for _ in range(m)] for _ in range(n)]

        maximal = 0

        for i in range(n-1, -1, -1):
            for j in range(m-1, -1, -1):
                if matrix[i][j] == '0':
                    sq[i][j] = 0
                    continue

                sq[i][j] = 1 + self.min_neighbor(i, j, sq, n, m)

                if maximal < sq[i][j]:
                    maximal = sq[i][j]
        return maximal ** 2
        

    def min_neighbor(self, i, j, sq, n, m):
        dirs = [(1, 0), (0, 1), (1, 1)]
        minimal = None
        for d in dirs:
            x, y = i + d[0], j + d[1]
            if x >= n or y >= m:
                return 0
            if minimal is None or sq[x][y] < minimal:
                minimal = sq[x][y]
        return minimal


def main():
    s = Solution()

    # m = [[1,0,1,0,0],
    #     [1,0,1,1,1],
    #     [1,1,1,1,1],
    #     [1,0,0,1,1]]

    m = [
        ["1","0","1","0","0"],
        ["1","0","1","1","1"],
        ["1","1","1","1","1"],
        ["1","0","0","1","0"]]

    print(s.maximalSquare(m))

if __name__ == '__main__':
    main()