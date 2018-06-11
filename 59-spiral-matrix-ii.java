/*
https://leetcode.com/problems/spiral-matrix-ii/description/

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

class Solution {
    
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Point[] dirs = new Point[]{new Point(0,1), new Point(1,0), new Point(0,-1), new Point(-1,0)};

    Point boundLeft;
    Point boundRight;

    private Point opposite(Point dir) {
        return new Point(-dir.x, -dir.y);
    }

    private Point getBound(Point dir) {
        Point bound = boundRight;
        if (dir.x < 0 || dir.y < 0) {
            bound = boundLeft;
        }
        return bound;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return null;
        }

        boundLeft = new Point(-1,-1);
        boundRight = new Point(n, n);

        int counter = 0;
        Point p = new Point(0, 0);
        int dirIdx = 0;

        while(true) {
            Point dir = dirs[dirIdx];
            Point bound = getBound(dir);

            while(true) {
                matrix[p.x][p.y] = ++counter;

                // next position
                p.x += dir.x;
                p.y += dir.y;
                // check out of boundary
                if (p.x == bound.x || p.y == bound.y) {
                    p.x -= dir.x;
                    p.y -= dir.y;
                    break;
                }
            }

            // next direction
            dirIdx = (dirIdx + 1) % dirs.length;
            dir = dirs[dirIdx];

            // move p
            p.x += dir.x;
            p.y += dir.y;

            // move boundary
            Point moveBound = getBound(opposite(dir));
            moveBound.x += dir.x;
            moveBound.y += dir.y;

            // check boundary
            if (boundLeft.x >= boundRight.x - 1 
            || boundLeft.y >= boundRight.y - 1) {
                break;
            }
        }

        return matrix;
    }
}