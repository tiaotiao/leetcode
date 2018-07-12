
class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        
        for x in nums: 
            if target == x: 
                return True
        return False