
class Solution {
    int[][] f;
    int n;
    int[] nums;
    
    public int maxCoins(int[] nums) {
        this.nums = nums;
        n = nums.length;
        
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        f = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (i == j) {
                    f[i][j] = A(i-1) * A(i) * A(i+1);
                    continue;
                }
                
                for (int k = i; k <= j; k++) {
                    int score = A(k) * A(i-1) * A(j+1) + F(i, k-1) + F(k+1, j);
                    f[i][j] = Math.max(f[i][j], score);
                }
            }
        }
        
        return f[0][n-1];
    }
    
    private int A(int i) {
        if (i < 0 || n <= i) return 1;
        return nums[i];
    }
    
    private int F(int i, int j) {
        if (i < 0 || j < 0 || n <= i || n <= j) return 0;
        if (i > j) return 0;
        return f[i][j];
    }
}