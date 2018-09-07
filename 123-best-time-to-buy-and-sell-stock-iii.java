

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        // left side
        int min = prices[0];
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            int p = 0;
            if (prices[i] > min) p = prices[i] - min;
            left[i] = Math.max(left[i-1], p);

            min = Math.min(min, prices[i]);
        }

        // right side
        int max = prices[n-1];
        right[n-1] = 0;
        for (int i = n-2; i >= 0; i--) {
            int p = 0;
            if (prices[i] < max) p = max - prices[i];
            right[i] = Math.max(right[i+1], p);

            max = Math.max(max, prices[i]);
        }

        int profit = left[n-1];
        for (int i = 0; i < n-1; i++) {
            profit = Math.max(profit, left[i]+right[i+1]);
        }

        return profit;
    }
}