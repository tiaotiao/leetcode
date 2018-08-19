

class Solution:
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        n = len(heights)
        if n <= 0: return 0
        
        leftLower = self.calcLowerArray(heights) 
        rightLower = self.calcLowerArray(list(reversed(heights)))
        # print(leftLower)
        # print(rightLower)
        m = 0
        for i in range(n):
            h = heights[i]
            left = leftLower[i][1]
            right = n - 1 - rightLower[n-i-1][1]
            area = h * (right - left - 1)
            # print(i, h, left, right, area)
            if m < area:
                m = area
        return m

    def calcLowerArray(self, heights):
        stack = MonotonicStack(key = lambda x: x[0])
        lower = []
        for i in range(len(heights)):
            h = heights[i]
            stack.push((h, i))
            if len(stack) <= 1:
                lower.append((0, -1))
            else:
                lower.append(stack[-2])
        return lower

class MonotonicStack:
    def __init__(self, key=None):
        self.stack = []
        if key == None:
            key = lambda x: x
        self.key = key

    def push(self, item):
        out = []
        while len(self.stack) > 0:
            k = self.key(item)
            top = self.key(self.stack[-1])
            if top < k:
                break
            out.append(self.pop())
        self.stack.append(item)
        return out
    
    def pop(self):
        if len(self.stack) == 0:
            return None
        return self.stack.pop()

    def __len__(self):
        return len(self.stack)

    def __getitem__(self, i):
        return self.stack[i]


def main():
    s = Solution()
    h = [2,1,5,6,2,3]
    h = [1, 1]
    print(s.largestRectangleArea(h))

if __name__ == '__main__':
    main()