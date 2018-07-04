
class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """

        self.n = len(board)
        if self.n <= 0: return
        self.m = len(board[0])
        if self.m <= 0: return

        self.tmp = "T"

        for i in range(self.n):
            for j in (0, self.m - 1):
                if board[i][j] == "O":
                    self.fill(board, i, j)
        for j in range(self.m):
            for i in (0, self.n-1):
                if board[i][j] == "O":
                    self.fill(board, i, j)

        print(board)
        self.replace(board, "O", "X")
        print(board)
        self.replace(board, self.tmp, "O")
        print(board)

    def fill(self, board, x, y):
        dirs = [(0,1), (1,0), (-1,0), (0,-1)]

        idx = 0
        queue = [(x,y)]
        board[x][y] = self.tmp
        while idx < len(queue):
            curr = queue[idx]
            idx += 1
            x = curr[0]
            y = curr[1]

            for d in dirs:
                newX = x + d[0]
                newY = y + d[1]
                if newX < 0 or self.n <= newX:
                    continue
                if newY < 0 or self.m <= newY:
                    continue
                if board[newX][newY] != "O":
                    continue
                queue.append((newX, newY))
                board[newX][newY] = self.tmp

    def replace(self, board, f, t):
        for i in range(self.n):
            for j in range(self.m):
                if board[i][j] == f:
                    board[i][j] = t





def main():
    s = Solution()
    board = [["X","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"],["O","X","O","O","O","O","X","O","O","O","O","O","O","O","O","O","O","O","X","X"],["O","O","O","O","O","O","O","O","X","O","O","O","O","O","O","O","O","O","O","X"],["O","O","X","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","X","O"],["O","O","O","O","O","X","O","O","O","O","X","O","O","O","O","O","X","O","O","X"],["X","O","O","O","X","O","O","O","O","O","X","O","X","O","X","O","X","O","X","O"],["O","O","O","O","X","O","O","X","O","O","O","O","O","X","O","O","X","O","O","O"],["X","O","O","O","X","X","X","O","X","O","O","O","O","X","X","O","X","O","O","O"],["O","O","O","O","O","X","X","X","X","O","O","O","O","X","O","O","X","O","O","O"],["X","O","O","O","O","X","O","O","O","O","O","O","X","X","O","O","X","O","O","X"],["O","O","O","O","O","O","O","O","O","O","X","O","O","X","O","O","O","X","O","X"],["O","O","O","O","X","O","X","O","O","X","X","O","O","O","O","O","X","O","O","O"],["X","X","O","O","O","O","O","X","O","O","O","O","O","O","O","O","O","O","O","O"],["O","X","O","X","O","O","O","X","O","X","O","O","O","X","O","X","O","X","O","O"],["O","O","X","O","O","O","O","O","O","O","X","O","O","O","O","O","X","O","X","O"],["X","X","O","O","O","O","O","O","O","O","X","O","X","X","O","O","O","X","O","O"],["O","O","X","O","O","O","O","O","O","O","X","O","O","X","O","X","O","X","O","O"],["O","O","O","X","O","O","O","O","O","X","X","X","O","O","X","O","O","O","X","O"],["O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"],["X","O","O","O","O","X","O","O","O","X","X","O","O","X","O","X","O","X","O","O"]]
    print(s.solve(board))

if __name__ == '__main__':
    main()