
class Solution:

    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        
        n = len(prices)
        if n <= 1: return 0
        if k >= n:
            return self.maxProfit_unlimited_transactions(prices)

        dp = [0 for i in range(k+1)]
        m = [-prices[0] for i in range(k+1)]

        for i in range(1, n):
            for t in range(k, 0, -1):
                m[t] = max(m[t], dp[t-1] - prices[i-1])
                dp[t] = max(dp[t], prices[i] + m[t])
        
        return dp[k]

    def maxProfit_unlimited_transactions(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        
        if len(prices) <= 1:
            return 0
        
        total = 0

        low, high = prices[0], prices[0]
        for p in prices:
            if p < high: # descending
                # sell previous stock
                total += high - low
                # start a new section
                low = p
                high = p
                continue
            # increasing high <= p
            high = p
        # sum up last section
        total += high - low
        
        return total

    def maxProfit_TimeLimitedExceeded(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        
        n = len(prices)
        if n <= 1:
            return 0

        dp = [[0 for i in range(n)] for j in range(k+1)]

        for t in range(1, k+1):
            m = -prices[0]
            for i in range(1, n):
                m = max(m, dp[t-1][i-1] - prices[i-1])
                dp[t][i] = max(dp[t][i-1], prices[i] + m)
        
        return dp[k][n-1]


def main():
    s = Solution()
    k = 2
    p = [3,3,5,0,0,3,1,4]
    print(s.maxProfit(k, p))

if __name__ == '__main__':
    main()
