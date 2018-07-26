
class Solution:
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0: return 0

        maximum = 1
        length = 1
        for i in range(1, len(nums)):
            if nums[i-1] >= nums[i]:
                length = 1
                continue
            length += 1
            if maximum < length:
                maximum = length
        
        return maximum

