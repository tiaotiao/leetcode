

class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;

        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int h = grid[i][j];
                if (h == 0) continue;
                int tower = 2 + (h * 4);

                final int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x < 0 || n <= x) continue;
                    if (y < 0 || m <= y) continue;

                    int neighbor = grid[x][y];
                    tower -= Math.min(h, neighbor);
                }

                area += tower;
            }
        }
        return area;
    }
}