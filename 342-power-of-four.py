
class Solution:
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        
        if num == 0:
            return False
        
        while num > 0:
            r = num % 4
            num //= 4
            if r == 0:
                continue
            if r != 1:
                return False
            if num != 0:
                return False
            return True
        return False