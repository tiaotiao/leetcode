
import java.util.*;

class Solution {
    
    private List<String> convert(char[][] board) {
        List<String> list = new ArrayList<>();
        
        int n = board.length;
        for (int i = 0; i < n; i++) {
            list.add(String.valueOf(board[i]));
        }
        return list;
    }
    
    private boolean canPlaceAt(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q' 
               || board[i][col] == 'Q') {
                return false;
            }
            
            int j = ((n-1-i)+(row+col-n+1));

            int k = (i+(col-row));
            
            // System.out.printf("i=%d, j=%d, k=%d, [%d, %d]\n", i, j, k, row, col);

            if ((0 <= j && j < n && board[i][j] == 'Q')
               || (0 <= k && k < n && board[i][k] == 'Q')) {
                return false;
            }
        }
        return true;
    }
    
    private void place(char[][] board, int row, int col) {
        board[row][col] = 'Q';
    }
    
    private void remove(char[][] board, int row, int col) {
        board[row][col] = '.';
    }
    
    private void Find(char[][] board, int row, List<List<String>> res) {
        int n = board.length;
        
        // System.out.println("Find row " + row);
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(board[i][j]);
        //     }
        //     System.out.println();
        // }

        if (row >= n) {
            res.add(convert(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (canPlaceAt(board, row, col)) {
                place(board, row, col);
                
                Find(board, row+1, res);
                
                remove(board, row, col);
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        Find(board, 0, res);
        
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> boards = s.solveNQueens(4);
        for (List<String> b : boards) {
            for (String row: b) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}