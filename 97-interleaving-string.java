
import java.util.*;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave_dp(s1, s2, s3);
    }

    public boolean isInterleave_dp(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;
        if (n == 0) return s2.equals(s3);
        if (m == 0) return s1.equals(s3);
        
        // dp[i][j] = true if everything before s3[i+j] is matched at s1[i] and s2[j]
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) continue;
                int k = i + j - 1;
                if (i > 0 && dp[i-1][j]) {
                    if (s1.charAt(i-1) == s3.charAt(k)) dp[i][j] = true;
                }
                if (j > 0 && dp[i][j-1]) {
                    if (s2.charAt(j-1) == s3.charAt(k)) dp[i][j] = true;
                }
            }
        }
        return dp[n][m];
    }

    public boolean isInterleave_bfs(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;
        if (n == 0) return s2.equals(s3);
        if (m == 0) return s1.equals(s3);
        
        
        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(0, 0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while (queue.size() > 0) {
            Item item = queue.poll();
            int index = item.i + item.j;
            if (index >= s3.length()) {
                return true;
            }
            char c3 = s3.charAt(index);

            if (item.i < n && s1.charAt(item.i) == c3) {
                if (!visited[item.i+1][item.j]) {
                    queue.add(new Item(item.i + 1, item.j));
                    visited[item.i+1][item.j] = true;
                }
            }
            if (item.j < m && s2.charAt(item.j) == c3) {
                if (!visited[item.i][item.j+1]) {
                    queue.add(new Item(item.i, item.j + 1));
                    visited[item.i][item.j+1] = true;
                }
            }
        }
        return false;
    }

    private class Item {
        int i, j;
        Item(int x, int y) {
            this.i = x; this.j = y;
        }
    }
}



class Main {
    public static void main(String[] args) {
        
        Solution s = new Solution();
        String s1 = "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb";
        String s2 = "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc";
        String s3 = "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc";

        System.out.println(s.isInterleave(s1, s2, s3));
    }
}