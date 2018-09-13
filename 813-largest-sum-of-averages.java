

class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        if (n == 0) return 0;
        
        double sum;
        double[][][] dp = new double[n][n][K+1];
        
        // init
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                dp[i][j][1] = sum / (j-i+1);
                dp[i][j][0] = 0;
            }
            sum -= A[i];
        }
        
        // dp
        for (int k = 2; k <= K; k++) {
            for (int len = 1; len <= n; len++) {
                for (int i = 0; i < n; i++) {
                    int j = i + len - 1;
                    if (j >= n) continue;
                    
                    dp[i][j][k] = dp[i][j][k-1];
                    for (int t = i; t < j; t++) {
                        double v1 = dp[i][t][1] + dp[t+1][j][k-1];
                        double v2 = dp[i][t][k-1] + dp[t+1][j][1];
                        dp[i][j][k] = Math.max(dp[i][j][k], v1);
                        dp[i][j][k] = Math.max(dp[i][j][k], v2);
                    }
                }
            }
        }
        
        return dp[0][n-1][K];
    }
}