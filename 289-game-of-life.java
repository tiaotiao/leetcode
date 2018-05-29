import com.sun.org.apache.regexp.internal.recompile;

/*
https://leetcode.com/problems/game-of-life/description/

289. Game of Life

According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean alive = isAlive(board, i, j);
                if (board[i][j] == 0 && alive) {
                    board[i][j] = -1;
                }
                if (board[i][j] == 1 && !alive) {
                    board[i][j] = 2;
                }
            } 
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private boolean isAlive(int[][] board, int i, int j) {
        int countAlive = 0;
        for (int r = -1; r <= 1; r++) {
            for (int t = -1; t <= 1; t++) {
                if (r == 0 && t == 0) {
                    continue;
                }
                int x = i + r;
                int y = j + t;
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                    continue;
                }

                if (board[x][y] > 0) {
                    countAlive += 1;
                }
            }
        }
        if (board[i][j] <= 0 && countAlive == 3) {
            return true;
        }
        if (board[i][j] > 0 && (countAlive < 2 || countAlive > 3)) {
            return false;
        }
        return board[i][j] > 0;
    }
}