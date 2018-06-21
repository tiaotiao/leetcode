class Solution:
    def rangeBitwiseAnd(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """

        for i in range(0, 32):
            pos = 31 - i
            a = self.bit(m, pos)
            b = self.bit(n, pos)

            if a == b:
                continue

            return (m >> (pos + 1)) << (pos + 1)

        return n & m
        
    def bit(self, num, i):
        return (num >> i) & 1
        

if __name__ == "__main__":
    s = Solution()

    tests = [(1, 1), (5, 7), (2, 6), (10, 11)]

    for t in tests:
        r = s.rangeBitwiseAnd(*t)
        print(bin(t[0]), bin(t[1]), r)