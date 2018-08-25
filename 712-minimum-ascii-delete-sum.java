

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n == 0) return asciiSum(s2);
        if (m == 0) return asciiSum(s1);

        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i <= n; i++) {
            char c1 = s1.charAt(i-1);
            for (int j = 1; j <= m; j++) {
                char c2 = s2.charAt(j-1);

                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (c1 == c2) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + c1 + c2);
                }
            }
        }

        return asciiSum(s1) + asciiSum(s2) - dp[n][m];
    }

    private int asciiSum(String s) {
        int sum = 0;
        for (char ch: s.toCharArray()) {
            sum += ch;
        }
        return sum;
    }
}