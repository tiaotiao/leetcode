
class Solution:
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        
        m = {}
        for i in range(len(nums)):
            num = nums[i]
            if num in m:
                prev = m[num]
                if abs(prev - i) <= k:
                    return True
            m[num] = i
        return False