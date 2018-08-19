
class Solution:
    class Rect:
        def __init__(self, A, B, C, D):
            self.left = A
            self.bottom = B
            self.right = C
            self.top = D

        def area(self):
            return (self.right - self.left) * (self.top - self.bottom) 
    
    def computeArea(self, A, B, C, D, E, F, G, H):
        r = Solution.Rect(A, B, C, D)
        t = Solution.Rect(E, F, G, H)

        area = r.area() + t.area() - self.intersection(r, t)
        return area

    def intersection(self, r, t):
        width = self.overlap(r.left, r.right, t.left, t.right)
        height = self.overlap(r.bottom, r.top, t.bottom, t.top)
        return width * height

    def overlap(self, low1, high1, low2, high2):
        low = max(low1, low2)
        high = min(high1, high2)
        if low >= high:
            return 0
        return high - low


def main():
    s = Solution()
    print(s.computeArea(A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2))

if __name__ == '__main__':
    main()