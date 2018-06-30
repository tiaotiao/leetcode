
class Solution:
    def peakIndexInMountainArray(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        left = 0
        right = len(A) - 1
        
        while left < right:
            mid = (left + right) // 2
            peak = self.isPeak(A, mid)
            if peak == 0:
                return mid
            if peak > 0:
                left = mid + 1
            else:
                right = mid - 1
        return left
        
    def isPeak(self, A, i):
        """
        :return 0:peak, 1:increasing, -1:decreasing
        """
        ls = False
        rs = False
        if i == 0 or A[i-1] < A[i]:
            ls = True
        if i == len(A)-1 or A[i] > A[i+1]:
            rs = True
        if ls and rs:
            return 0
        if ls:
            return 1
        return -1
