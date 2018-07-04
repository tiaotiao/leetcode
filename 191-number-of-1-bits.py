
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        bits = 0
        while n > 0:
            b = n & 1
            n >>= 1
            bits += b

        return bits