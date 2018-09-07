

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (m == 0 && n == 0) return 0;
        if (strs.length == 0) return 0;
        
        // m 0s, n 1s
        int[][] f = new int[m+1][n+1];
        f[0][0] = 1;
        int max = 1;

        for (String s : strs) {
            // count 1 and 0 of s
            int ones = 0, zeros = 0;
            for (char c: s.toCharArray()) {
                if (c == '0') zeros += 1;
                else ones += 1;
            }

            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (f[i][j] == 0) continue;
                    int x = i + zeros;
                    int y = j + ones;
                    if (x > m || y > n) continue;
                    f[x][y] = Math.max(f[x][y], f[i][j] + 1);

                    max = Math.max(max, f[x][y]);
                }
            }
        }

        return max-1;
    }
}