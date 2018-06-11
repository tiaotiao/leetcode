/*
https://leetcode.com/problems/spiral-matrix/description/

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
[ 1, 2, 3 ],
[ 4, 5, 6 ],
[ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
[1, 2, 3, 4],
[5, 6, 7, 8],
[9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

class Solution {

    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int n = matrix.length;
        if (n == 0) {
            return result;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return result;
        }

        Point[] dirs = new Point[]{new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0)};
        
        Point[] boundary = new Point[]{new Point(-1,-1), new Point(n, m)};
        
        // init p and direction
        Point p = new Point(0, 0);
        int dirIdx = 0;
        Point dir = dirs[dirIdx];

        while(true) { 
            Point bound = boundary[0];
            if (dir.x > 0 || dir.y > 0) {
                bound = boundary[1];
            }
            
            // go one direction
            while(true) {   // p is not out of boundary
                result.add(matrix[p.x][p.y]);

                // next position
                p.x += dir.x;
                p.y += dir.y;

                // check if out of boundary
                if (bound.x == p.x || bound.y == p.y) {
                    // go back into boundary
                    p.x -= dir.x;
                    p.y -= dir.y;
                    break;
                }
            }

            // next direction
            dirIdx = (dirIdx + 1) % dirs.length;
            dir = dirs[dirIdx];

            // move p to next start point
            p.x += dir.x;
            p.y += dir.y;

            // move boundary
            bound = boundary[1];
            if (dir.x > 0 || dir.y > 0) {
                bound = boundary[0];
            }
            bound.x += dir.x;
            bound.y += dir.y;
            if (boundary[0].x >= boundary[1].x - 1
            || boundary[0].y >= boundary[1].y - 1) {
                break;
            }
        }
        return result;
    }
}
