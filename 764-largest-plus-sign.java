
class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (N == 0) return 0;

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 1;
            }
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        // DP compute the maximum length of 1s at (i,j) of direction k.
        int[][][] ones = new int[N][N][4];

        final int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < dirs.length; k++) {
                    int xi = i;
                    int yj = j;
                    if (k >= 2) {
                        xi = N - 1 - i;
                        yj = N - 1 - j;
                    }
                    
                    if (grid[xi][yj] == 0) {
                        ones[xi][yj][k] = 0;
                        continue;
                    }
                    
                    int[] dir = dirs[k];
                    int x = xi + dir[0];
                    int y = yj + dir[1];

                    int c = 0;
                    if (0 <= x && x < N && 0 <= y && y < N) {
                        c = ones[x][y][k];
                    }

                    ones[xi][yj][k] = c + 1;
                }
            }
        }

        // get result
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) continue;
                
                int order = Integer.MAX_VALUE;
                for (int k = 0; k < 4; k++) {
                    int[] dir = dirs[k];
                    int x = i + dir[0];
                    int y = j + dir[1];
                    int len = 1;
                    if (0 <= x && x < N && 0 <= y && y < N) {
                        len = ones[x][y][k] + 1;
                    }
                    order = Math.min(order, len);
                }
                max = Math.max(max, order);
            }
        }

        return max;
    }
}