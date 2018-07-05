
class Solution:
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """

        nums = []
        combs = []

        self.combine(1, k, n, nums, combs)

        return combs

    def combine(self, t, k, n, nums, combs):
        """
        use k nums of [t, 9] to sum up to n
        """
        if k == 0:
            if n == 0:  # found a combination
                comb = nums[:]
                combs.append(comb)
            return
        
        # cut off branches
        if t > 9: return
        m = 9 - t + 1
        if m < k: return
        if t > n: return
        a = 0
        for i in range(t, 10):
            a += i 
        if n > a: return
        
        # combine
        nums.append(t)
        self.combine(t + 1, k - 1, n - t, nums, combs)
        nums.pop()

        self.combine(t + 1, k, n, nums, combs)


def main():
    s = Solution()

    print(s.combinationSum3(3, 7))

if __name__ == '__main__':
    main()