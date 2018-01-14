/*
https://leetcode.com/problems/rotate-image/description/

48. Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/

import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 0) {
            return;
        }
        int halfRow = n / 2;
        int halfCol = (n+1) / 2;

        for (int i = 0; i < halfRow; i++) {
            for (int j = 0; j < halfCol; j++) {
                int x = i, y = j;
                int val = matrix[i][j], tmp;
                for (int k = 0; k < 3; k++) {
                    int s = y;
                    int t = n-x-1;
                    tmp = matrix[s][t];
                    matrix[s][t] = val;
                    val = tmp;
                    x = s;
                    y = t;
                }
                matrix[i][j] = val;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] matrix = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        
        solution.rotate(matrix);

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}