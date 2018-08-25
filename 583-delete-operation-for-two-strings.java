
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0) return m;
        if (m == 0) return n;

        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;

        for (int i = 1; i <= n; i++) {
            char c1 = word1.charAt(i-1);
            for (int j = 1; j <= m; j++) {
                char c2 = word2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return n + m - 2 * dp[n][m];
    }
}