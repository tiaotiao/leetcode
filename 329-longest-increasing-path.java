
class Solution {
    int n, m;
    int[][] matrix;
    int[][] f;
    boolean[][] visited;
    final int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length;
        if (n == 0) return 0;
        m = matrix[0].length;
        if (m == 0) return 0;
        
        visited = new boolean[n][m];
        f = new int[n][m];
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                f[i][j] = visit(i, j);
                max = Math.max(max, f[i][j]);
            }
        }
        
        return max;
    }
    
    private int visit(int i, int j) {
        if (visited[i][j]) return f[i][j];
        int len = 1;
        int val = matrix[i][j];
        
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || n <= x) continue;
            if (y < 0 || m <= y) continue;
            if (val >= matrix[x][y]) continue;
            len = Math.max(len, visit(x, y) + 1);
        }
        
        f[i][j] = len;
        visited[i][j] = true;
        return len;
    }
}