
class Solution(object):
    def totalHammingDistance(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums)
        if n <= 1: return 0
        
        distance = 0
        while True:
            allZero = True
            s = 0
            for i in range(n):
                num = nums[i]
                if num != 0:
                    allZero = False
                b = num & 1
                nums[i] = num >> 1
                s += b
                
            if allZero:  
                break

            distance += self.allPairDistance(n, s)

        return distance
        
    def allPairDistance(self, n, s):
        return (n - s) * s
    