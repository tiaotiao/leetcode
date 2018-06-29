
class Solution:
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """

        visited = set()
        
        while True:
            # print("  >>", n)
            if n in visited:
                break
            visited.add(n)

            n = self.sumOfSquares(n)
            if n == 1:
                return True
        return False


    def sumOfSquares(self, n):
        digits = self.split(n)
        sum = 0
        for d in digits:
            sum += d*d
        return sum 
    
    def split(self, n):
        if n == 0:
            return [0]
        digits = []
        while n > 0:
            digits.append(n % 10)
            n //= 10
        return digits

def main():
    s = Solution()

    tests = range(20)

    for t in tests:
        result = s.isHappy(t)
        print("testing:", t, result)

if __name__ == '__main__':
    main()