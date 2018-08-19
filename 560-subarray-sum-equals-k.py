from collections import defaultdict

class Solution:
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        return self.solve_n(nums, k)

    def solve_n(self, nums, k):
        n = len(nums)
        if n == 0: return 0

        pre = defaultdict(int)
        pre[0] = 1

        s, count = 0, 0
        for i in range(n):
            num = nums[i]
            s += num
            e = s - k
            count += pre[e]
            pre[s] += 1
        return count

    def solve_n2_TLE(self, nums, k):
        n = len(nums)
        if n == 0: return 0

        pre = []
        s = 0
        for num in nums:
            s += num
            pre.append(s)
    
        def subSum(i, j):
            if i == 0:
                return pre[j]
            return pre[j] - pre[i-1]

        count = 0
        for i in range(n):
            for j in range(i, n):
                sub = subSum(i, j)
                if sub == k:
                    count += 1
        return count

def main():
    s = Solution()
    nums = [1,2,3,2,1,1,1]
    k = 3
    print(s.subarraySum(nums, k))

if __name__ == '__main__':
    main()