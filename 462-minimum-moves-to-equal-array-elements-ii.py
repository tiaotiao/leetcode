
class Solution:
    def minMoves2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0

        nums.sort()
        mid = nums[len(nums) // 2]

        diffs = 0
        for i in nums:
            diffs += abs(mid - i)

        return diffs

