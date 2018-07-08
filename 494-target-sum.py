
class Solution:
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """

        MAX_SUM = 2002
        if S > MAX_SUM:
            return 0

        dp = [[None] * MAX_SUM]
        dp[0][0] = 1

        for i in range(len(nums)):
            idx = i + 1
            num = nums[i]
            dp.append([None] * MAX_SUM)
            for j in range(-MAX_SUM//2, MAX_SUM//2):
                if dp[idx - 1][j] is None:
                    continue
                prevSum = j
                numWays = dp[idx - 1][j]
                # update dp[idx][s]
                # print(idx, "prev", prevSum, numWays)
                s = prevSum + num
                self.update(dp, idx, s, numWays)

                s = prevSum - num
                self.update(dp, idx, s, numWays)

        ways = dp[len(nums)][S]
        if not ways:
            return 0
        return ways

    def update(self, dp, idx, s, ways):
        # print(idx, s)
        if dp[idx][s] is None:
            dp[idx][s] = ways
        else:
            dp[idx][s] += ways


def main():
    s = Solution()
    nums = [1,1,1,1,1]
    S = 3
    print(s.findTargetSumWays(nums, S))

if __name__ == '__main__':
    main()