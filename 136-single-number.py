class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        s = 0
        for num in nums:
            s = s ^ num
        return s