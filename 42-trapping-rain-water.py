
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        return self.solution_n(height)

    def solution_n(self, height):
        if len(height) == 0: return 0
        
        left, right = 0, len(height) - 1
        leftMax, rightMax = 0, 0
        total = 0

        while left < right:
            if height[left] < height[right]:
                if leftMax <= height[left]:
                    leftMax = height[left]
                else:
                    total += leftMax - height[left]
                left += 1
            else:
                if rightMax <= height[right]:
                    rightMax = height[right]
                else:
                    total += rightMax - height[right]
                right -= 1
        return total

    def solution_nlogn(self, height):
        columns = [(height[i], i) for i in range(len(height))]

        columns.sort(key = lambda c: c[0], reverse = True)

        total = 0
        left, right = None, None

        for h, i in columns:
            if left == None or right == None:
                left, right = i, i
                continue
            
            if left < i and i < right:
                total -= h
                continue
            
            width = 0
            if i < left: 
                width = left - i - 1
                left = i
            if right < i:
                width = i - right - 1
                right = i
            
            total += width * h
        
        return total

        