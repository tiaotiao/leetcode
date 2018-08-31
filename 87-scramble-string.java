

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        if (n == 0) return true;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        // init
        boolean[][][] f = new boolean[n][n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (c1[i] == c2[j]) {
                    f[i][j][1] = true;
                }
            }
        }

        // dp
        for (int len = 2; len <= n; len ++) {
            for (int i = 0; i + len <= n; i++) {
                for (int j = 0; j + len <= n; j++) {
                    for (int k = 1; k < len; k++) {
                        int t = len - k;
                        if ((f[i][j][k] && f[i+k][j+k][t]) 
                        || (f[i][j+t][k] && f[i+k][j][t])) {
                            f[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }

        return f[0][0][n];
    }
}