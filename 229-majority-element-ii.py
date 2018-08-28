

class Solution:
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        maj1, maj2 = None, None
        count1, count2 = 0, 0
        for num in nums:
            if maj1 == num:
                count1 += 1
            elif maj2 == num:
                count2 += 1
            elif maj1 == None:
                maj1 = num
                count1 = 1
            elif maj2 == None:
                maj2 = num
                count2 = 1
            else:
                count1 -= 1
                count2 -= 1
                if count1 == 0: maj1 = None
                if count2 == 0: maj2 = None
        res = []
        if nums.count(maj1) > len(nums) / 3: res.append(maj1)
        if nums.count(maj2) > len(nums) / 3: res.append(maj2)
        return res
        
