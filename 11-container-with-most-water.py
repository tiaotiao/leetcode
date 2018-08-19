

class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        n = len(height)
        if n < 2: return 0
        
        m = 0
        left, right = 0, n-1
        while left < right:
            l = height[left]
            r = height[right]
            w = (right - left)

            if l < r:
                h = l
                left += 1
            else:
                h = r
                right -= 1
            
            area = h * w
            if m < area:
                m = area
        return m

def main():
    s = Solution()
    h = [1,8,6,2,5,4,8,3,7]
    print(s.maxArea(h))

if __name__ == '__main__':
    main()
