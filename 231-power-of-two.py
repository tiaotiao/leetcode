
class Solution:
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """

        while n > 0:
            b = n & 1
            n >>= 1
            if b == 1:
                if n > 0:
                    return False
                return True
        return False