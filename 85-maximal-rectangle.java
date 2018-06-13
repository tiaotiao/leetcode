/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
["1","0","1","0","0"],
["1","0","1","1","1"],
["1","1","1","1","1"],
["1","0","0","1","0"]
]

Output: 6
*/

import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }

        int[][] heights = calcHeights(matrix, n, m);
        
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            int mx = largestRectangle(heights[i]);
            if (max < mx) {
                max = mx;
            }
        }

        return max;
    }

    private int[][] calcHeights(char[][] matrix, int n, int m) {
        int[][] heights = new int[n][m];

        for (int j = 0; j < m; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == '1') {
                    count += 1;
                } else {
                    count = 0;
                }
                heights[i][j] = count;
            }
        }

        return heights;
    }

    // the same as problem 84 largest-rectangle-in-histogram
    private int largestRectangle(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int max = 0;
        
        int n = heights.length + 2;
        int[] a = new int[n];
        for (int i = 0; i < heights.length; i++) {
            a[i+1] = heights[i];
        }
        a[0] = 0;
        a[n-1] = 0;

        for (int i = 0; i < n; i++) {
            int h = a[i];

            while(!s.empty() && a[s.peek()] > h) {
                // pop 
                int idx = s.pop();
                int height = a[idx];
                int right = i - 1;
                int left = idx;
                if (!s.empty()) {
                    left = s.peek() + 1;
                }
                int area = height * (right - left + 1);
                if (max < area) {
                    max = area;
                }
            }

            s.push(i);
        }

        return max;
    }
}

