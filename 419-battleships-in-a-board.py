

class Solution:
    def countBattleships(self, board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        
        n = len(board)
        if n == 0: return 0
        m = len(board[0])
        if m == 0: return 0

        dirs = [(-1,0), (0,-1)]

        count = 0
        for i in range(n):
            for j in range(m):
                if board[i][j] != 'X': 
                    continue
                ok = True
                for d in dirs:
                    x = i + d[0]
                    y = j + d[1]
                    if x < 0 or n <= x: continue
                    if y < 0 or m <= y: continue

                    if board[x][y] == 'X':
                        ok = False
                        break

                if ok:
                    count += 1
        return count


def main():
    s = Solution()

    board = [['X', '.', 'X','X'],
            ['X','.','.','.'],
            ['.','X','X','X']]
    print(s.countBattleships(board))

if __name__ == '__main__':
    main()      