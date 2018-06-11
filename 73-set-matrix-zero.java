/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

class Solution {

    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;

        // mark
        // using the first row and first column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    if (i != 0 && j != 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    } 
                }
            }
        }

        // fill rows
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {    // fill row
                fillRow(matrix, i);
            }
        }

        // fill cols
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {    // fill col
                fillCol(matrix, j);
            }
        }

        if (firstRow) fillRow(matrix, 0);
        if (firstCol) fillCol(matrix, 0);
    }
    
    private void fillRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = 0;
        }
    }

    private void fillCol(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }

}