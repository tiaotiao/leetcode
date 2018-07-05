class Solution:
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        return self.countingSort(nums)
        
    def countingSort(self, nums):
        count = [0, 0, 0]
        for num in nums:
            count[num] += 1
        i = 0
        for num in range(0, 3):
            for _ in range(0, count[num]):
                nums[i] = num
                i += 1