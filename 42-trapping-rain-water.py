
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        return self.solution_monotonic_stack(height)

    def solution_monotonic_stack(self, height):
        n = len(height)
        if n == 0: return 0

        water = 0
        s = []  # stack
        for i in range(n):
            h = height[i]
            while len(s) > 0 and height[s[-1]] <= h:
                bottom = height[s.pop()]
                left = -1 if len(s) == 0 else s[-1]
                boundary = 0 if len(s) == 0 else min(h, height[s[-1]])
                w = (i - left - 1) * (boundary - bottom)
                if w > 0:
                    water += w
            s.append(i)
        return water

    def solution_n_boundaries(self, height):
        n = len(height)
        if n == 0: return 0

        m = 0
        leftmax = [0] * n
        for i in range(n):
            leftmax[i] = m
            h = height[i]
            if m < h: m = h
        m = 0
        rightmax = [0] * n
        for i in range(n-1,-1,-1):
            rightmax[i] = m
            h = height[i]
            if m < h: m = h
        water = 0
        for i in range(n):
            w = 0
            boundary = min(leftmax[i], rightmax[i])
            w = boundary > height[i]
            if w < 0: w = 0
            water += w
        return water

    def solution_n_two_pointers(self, height):
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

        