

class Solution:

    def maxProfit(self, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        
        k = 2
        n = len(prices)
        if n <= 1: return 0

        dp, m = [], []
        for t in range(0, k+1):
            dp.append(0)
            m.append(-prices[0])

        for i in range(1, n):
            for t in range(k, 0, -1):
                m[t] = max(m[t], dp[t-1] - prices[i-1])
                dp[t] = max(dp[t], prices[i] + m[t])
        
        return dp[k]


    # --------------------------------------------- 

    def maxProfit_TimeLimitExceeded(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        
        if len(prices) <= 1:
            return 0
        
        maximum = 0
        for i in range(len(prices)):
            p1 = self.maxOneTransaction(prices[:i])
            p2 = self.maxOneTransaction(prices[i:])
            p = p1 + p2
            if maximum < p:
                maximum = p
        return maximum
        

    def maxOneTransaction(self, prices):
        
        if len(prices) <= 1:
            return 0
        
        profit = 0
        minPrice = prices[0]
        for price in prices:
            prof = price - minPrice
            if prof > profit:
                profit = prof
            if price < minPrice:
                minPrice = price
        return profit