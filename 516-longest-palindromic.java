/*
https://leetcode.com/problems/longest-palindromic-subsequence/description/

Given a string s, find the longest palindromic subsequence's length in s. 
You may assume that the maximum length of s is 1000.

Example 1:
Input:
"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:
"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
*/


class Solution {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] m = new int[n][n];  // length of the sequence
        int[][] p = new int[n][n];  // previous step is from 0:[i+1,j-1] 1:[i,j-1] -1:[i+1,j]

        // init
        for (int i = 0; i < n; i++) {
            m[i][i] = 1;
            p[i][i] = 0;
        }

        // DP
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n-k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j)) {
                    m[i][j] = m[i+1][j-1] + 2;
                    p[i][j] = 0;
                } else {
                    if (m[i][j-1] > m[i+1][j]) {
                        m[i][j] = m[i][j-1];
                        p[i][j] = 1;
                    } else {
                        m[i][j] = m[i+1][j];
                        p[i][j] = -1;
                    }
                }
            }
        }

        // get the result
        String left = "";
        String right = "";
        String result = "";
        int i = 0;
        int j = n-1;
        while (i < j) {
            if (p[i][j] == 0) {
                left = left + s.substring(i,i+1);
                right = s.substring(j,j+1) + right;
                i += 1;
                j -= 1;
            } else if (p[i][j] == 1) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        if (i==j) {
            result = left + s.substring(i,i+1) + right;
        } else {
            result = left + right;
        }

        //System.out.println(m[0][n-1]);

        return result.length();
    }
}


//////////////////////////////////////////////////////////////////////////////


class Main {

    static class test {
        String s;
        int expect;
        public test(String s, int expect) {
            this.s = s;
            this.expect = expect;
        }
    }

    public static void main(String[] args) {
        test[] cases = {
            new test("bbbab", 4),
            new test("cbbd", 2),
            new test("a", 1)
        };

        Solution solution = new Solution();

        boolean ok = true;
        for (test c: cases) {
            int res = solution.longestPalindromeSubseq(c.s);
            if (res != c.expect) {
                System.out.printf("ERROR: %s expect %d, result=%d\n", c.s, c.expect, res);
                ok = false;
            }
        }
        if (ok) {
            System.out.println("ok");
        }
    }
}








