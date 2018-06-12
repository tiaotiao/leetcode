/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        if (n == 0) {
            return A;
        }
        int m = A[0].length;
        if (m == 0) {
            return A;
        }
        int mid = m / 2;
        if (m % 2 == 1) mid ++;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int k = n - j - 1;
                int l = A[i][j];
                int r = A[i][k];
                A[i][j] = flip(r);
                A[i][k] = flip(l);
            }
        }

        return A;
    }

    private int flip(int x) {
        if (x == 1) return 0;
        return 1;
    }
}

