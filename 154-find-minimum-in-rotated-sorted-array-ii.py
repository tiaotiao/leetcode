

class Solution:
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        previous = None
        for num in nums:
            if previous != None and previous > num:
                return num
            previous = num
        return nums[0] 
