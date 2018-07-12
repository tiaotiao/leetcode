
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
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

        