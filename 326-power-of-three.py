
class Solution:
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 0:
            return False

        while n > 0:
            d = n % 3
            n = n // 3
            # print(d, n)
            if d == 2:
                return False
            if d == 1:
                if n > 0:
                    return False
                return True
        return False

def main():
    s = Solution()

    print(s.isPowerOfThree(27))

if __name__ == '__main__':
    main()