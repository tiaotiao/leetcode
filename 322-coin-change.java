/*
https://leetcode.com/problems/coin-change/description/

You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] m = new int[amount+1]; // m[k] represents the minimal number of coins to make up k amount of money.

        // init
        for (int i = 0; i <= amount; i++) {
            m[i] = -1;
        }
        m[0] = 0;

        // DP
        for (int i = 0; i <= amount; i++) {
            if (m[i] < 0) {
                continue;
            }
            for (int c: coins) {
                int k = i + c;
                long l = (long)i + (long)c;
                if (l > amount) {
                    continue;
                }
                if (m[k] < 0) {
                    m[k] = m[i] + 1;
                } else {
                    m[k] = Math.min(m[k], m[i]+1);
                }
            }
        }

        return m[amount];
    }
}


////////////////////////////////////////////////////////////////////////////


class Main {
    public static void main(String[] args) {
        test[] cases = {
            new test(new int[]{1,2,5}, 11, 3),
            new test(new int[]{2}, 3, -1),
            new test(new int[]{1,2147483647}, 2, 2),
        };

        Solution solution = new Solution();
        boolean ok = true;
        for (test c: cases) {
            int res = solution.coinChange(c.coins, c.amount);
            if (res != c.expect) {
                System.out.printf("Error: expect %d , result=%d\n", c.expect, res);
                ok = false;
            }
        }
        if (ok) {
            System.out.println("ok");
        }
    }

    static class test {
        int[] coins;
        int amount;
        int expect;
        test(int[] c, int n, int e) { coins=c; amount=n; expect=e; }    
    }
}