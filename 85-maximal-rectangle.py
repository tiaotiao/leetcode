
class Solution:
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        n = len(matrix)
        if n == 0: return 0
        m = len(matrix[0])
        if m == 0: return 0

        maximum = 0
        heights = [0] * m
        for i in range(n):
            # compute heights of current row
            for j in range(m):
                if matrix[i][j] == "0":
                    heights[j] = 0
                else:
                    heights[j] += 1
            # compute the max area rectangle of the row
            # same as 84. Largest Rectangle in Histogram
            leftBoundary = self.boundary(heights)
            r = self.boundary(list(reversed(heights)))

            rightBoundary = [m-1-r[m-j-1] for j in range(m)]
            # max area for this row
            # print("heights", heights)
            # print(leftBoundary)
            # print(rightBoundary)
            for j in range(m):
                left, right = leftBoundary[j], rightBoundary[j]
                area = heights[j] * (right - left - 1)
                if maximum < area:
                    maximum = area
        return maximum

    def boundary(self, heights):
        stack = MonotonicStack(key=lambda x: x[0])
        boundary = []
        for i in range(len(heights)):
            h = heights[i]
            stack.push((h, i))
            if len(stack) <= 1:
                boundary.append(-1)
            else:
                boundary.append(stack[-2][1])
            # print("s", stack.stack)
            # print("b", boundary)
        return boundary

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
    m = [
    ["1","0","1","0","0"],
    ["1","0","1","1","1"],
    ["1","1","1","1","1"],
    ["1","0","0","1","0"]
    ]

    print(s.maximalRectangle(m))

if __name__ == '__main__':
    main()