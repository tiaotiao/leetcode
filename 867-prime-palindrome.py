
import math

class Solution:
    def primePalindrome(self, N):
        """
        :type N: int
        :rtype: int
        """
        self.N = N
        
        for numDigits in range(1, 10):
            res = self.generatePalindorme(numDigits, 0, [0] * numDigits)
            if res != None:
                return res
        return None
    

    def generatePalindorme(self, numDigits, index, digits):
        if index > (numDigits - 1) // 2:
            s = "".join(str(i) for i in digits)
            num = int(s)
            if self.N > num:
                return None
            if not self.isPrime(num):
                return None
            # print(num)
            return num
        
        r = range(10)
        if index == 0 and numDigits > 1:
            r = [1,3,7,9]
        
        for d in r:
            digits[index] = d
            digits[-(index  + 1)] = d
            res = self.generatePalindorme(numDigits, index + 1, digits)
            if res:
                return res
        return None

    def isPrime(self, num):
        if num == 1: return False
        # print("isPrime", num)
        sq = int(math.sqrt(num))
        for i in range(2, sq+1):
            if num % i == 0:
                return False
        return True



def main():
    s = Solution()

    s.primePalindrome(1)

if __name__ == '__main__':
    main()