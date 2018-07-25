
class Solution:
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        s = sum(nums)
        if s % 2 != 0: return False
        target = s // 2

        dp = [False for _ in range(target + 1)]
        dp[0] = True

        for x in nums:
            for i in range(target, -1, -1):
                if not dp[i]: continue
                y = x + i
                if y > target: continue
                dp[y] = True
        return dp[target]

def main():
    s = Solution()

    nums = [1, 5, 11, 5]
    nums = [1, 2, 3, 5]
    print(s.canPartition(nums))

if __name__ == '__main__':
    main()