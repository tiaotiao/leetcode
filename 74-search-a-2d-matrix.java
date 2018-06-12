/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {        
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }


        int row = searchRow(matrix, target);
        if (row < 0 || matrix.length <= row) {
            return false;
        }
        int col = searchCol(matrix[row], target);
        if (col < 0 || matrix[row].length <= col) {
            return false;
        }
        return true;
    }

    private int searchRow(int[][] matrix, int target) {
        int min = 0;                // included
        int max = matrix.length;    // not included

        if (target < matrix[min][0]) {
            return -1;
        }

        while(min < max-1) {
            int mid = (min + max) / 2;
            int val = matrix[mid][0];
            if (target == val) {
                return mid;
            } else if (target < val) {
                max = mid;
            } else {
                min = mid;
            }
        }

        return min;
    }

    private int searchCol(int[] row, int target) {
        int min = 0;                // included
        int max = row.length - 1;   // included

        while(min <= max) {
            int mid = (min + max) / 2;
            int val = row[mid];
            if (target == val) {
                return mid;
            } else if (target < val) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }
}