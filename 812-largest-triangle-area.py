
import math

class Solution:
    def largestTriangleArea(self, points):
        """
        :type points: List[List[int]]
        :rtype: float
        """
        maximum = 0.0
        for a in points:
            for b in points:
                for c in points:
                    if a == b or b == c or a == c:
                        continue
                    area = self.calcArea(a, b, c)
                    # print("   ", a, b, c, " -> ", area)
                    if maximum < area:
                        maximum = area
        return maximum

    def calcArea(self, a, b, c):
        buttom = self.distance(a, b)
        height = self.distanceToLine(c, a, b)
        # print("       ", buttom, height)
        area = buttom * height / 2.0
        return area

    def distance(self, a, b):
        return math.sqrt((a[0] - b[0])**2 + (a[1] - b[1])**2)

    def distanceToLine(self, p, a, b):
        # d = |ap * ab| / |ab|
        ap = [p[0] - a[0], p[1] - a[1]]
        ab = [b[0] - a[0], b[1] - a[1]]

        d_ab = self.distance(a, b)
        d_ap = self.distance(a, p)

        d = self.crossProduct(ap, ab) / d_ab

        dist = math.sqrt(d_ap**2 - d**2)
        return dist
        

    def crossProduct(self, va, vb):
        product = 0
        for i in range(0, len(va)):
            product += va[i] * vb[i]
        return product


####################################################


def test():
    s = Solution()
    points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
    area = s.largestTriangleArea(points)
    print(area)

if __name__ == "__main__":
    test()