
class Solution:
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        if n == 0:
            return 1
        if n < 0 or n > 10:
            return 0

        total = 9
        for i in range(9, 9-n+1, -1):
            total = total * i
        # print(n, total)

        total += self.countNumbersWithUniqueDigits(n-1)
        return total

def main():
    s = Solution()

    print(s.countNumbersWithUniqueDigits(3))

if __name__ == '__main__':
    main()