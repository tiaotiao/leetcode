

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<Integer>();
        int totalGrids = n * m;

        if (totalGrids == 0 || operators == null || operators.length == 0) {
            return res;
        }

        int[][] grids = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grids[i][j] = -1;   // sea
            }
        }
        
        UnionFind u = new UnionFind(totalGrids);

        int counter = 0;
        int islands = 0;
        for (Point op: operators) {
            if (grids[op.x][op.y] != -1) {
                res.add(islands);
                continue;
            }
            grids[op.x][op.y] = counter++;

            // merge with neighbors
            final int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
            for (int[] dir: dirs) {
                int x = op.x + dir[0];
                int y = op.y + dir[1];
                if (x < 0 || y < 0 || n <= x || m <= y) {
                    continue;
                }
                if (grids[x][y] != -1) {
                    u.union(grids[op.x][op.y], grids[x][y]);
                }
            }

            islands = counter - (totalGrids - u.count());
            res.add(islands);
        }

        return res;
    }
}

class UnionFind {
    private int[] s;
    private int cnt;
    public UnionFind(int size) {
        s = new int[size];
        for (int i = 0; i < size; i++) {
            s[i] = -1;
        }
        cnt = size;
    }

    public int union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) {
            s[ra] = rb;
            cnt -= 1;
        }
        return rb;
    }

    public int find(int a) {
        if (s[a] == -1) {
            return a;
        }
        int root = find(s[a]);
        s[a] = root;
        return root;
    }

    public int count() {
        return cnt;
    }
}