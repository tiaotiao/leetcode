/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/


class Solution {
    char[][] board;
    boolean[][] mark;
    String word;
    int n, m;
    int dirs[][] = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        this.word = word;

        this.board = board;
        n = board.length;
        if (n == 0) {
            return false;
        }
        m = board[0].length;
        if (m == 0) {
            return false;
        }

        mark = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(int x, int y, int index) {
        char ch = word.charAt(index);

        if (board[x][y] != ch) {
            return false;
        }
        
        if (index + 1 >= word.length()) {
            return true;
        }
        
        mark[x][y] = true;
        for (int[] dir: dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= n 
            || newY < 0 || newY >= m) {
                continue;
            }
            if (mark[newX][newY]) {
                continue;
            }
            if (bfs(newX, newY, index + 1)) {
                return true;
            }
        }
        mark[x][y] = false;
        return false;
    }
}