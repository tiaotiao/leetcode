

class Solution:
    def maxProfit(self, prices):
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
                

def main():
    s = Solution()

    print(s.maxProfit([7,1,5,3,6,4]))

if __name__ == '__main__':
    main()