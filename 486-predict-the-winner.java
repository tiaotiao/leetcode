
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        
        int total = 0;
        for (int num: nums) total += num;
        
        int[][] f = new int[n][n];
        int[][] p = new int[n][n];
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i <= n-k; i++) {
                int j = i + k - 1;
                if (i == j) {
                    f[i][j] = nums[i];
                    p[i][j] = 0;
                    continue;
                }
                
                int vi = nums[i] + p[i+1][j];
                int vj = nums[j] + p[i][j-1];
                
                if (vi > vj) {
                    f[i][j] = vi;
                    p[i][j] = f[i+1][j];
                } else {
                    f[i][j] = vj;
                    p[i][j] = f[i][j-1];
                }
            }
        }
        
        int value = f[0][n-1];
        if (value * 2 >= total) return true;
        return false;
    }
}