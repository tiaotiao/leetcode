
class Solution:
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        return self.countDP(num)

    # O(n)
    def countDP(self, num):
        res = [0]
        high = 1
        for i in range(1, num+1):
            if high<<1 <= i:
                high <<= 1
            prev = i & (~high)
            res.append(1 + res[prev])
        return res
    
    # O(n * sizeof(int))
    def countForEveryNumber(self, num):
        res = []

        for i in range(0, num+1):
            c = self.count(i)
            res.append(c)

        return res

    def count(self, num):
        c = 0
        while num > 0:
            if num & 1 == 1:
                c += 1
            num >>= 1
        return c


def main():
    s = Solution()

    print(s.countDP(100))

if __name__ == '__main__':
    main()