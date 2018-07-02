class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
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


def main():
    s = Solution()

    print(s.maxProfit([7,1,5,3,6,4]))

if __name__ == '__main__':
    main()