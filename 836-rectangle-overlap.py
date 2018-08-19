


class Solution:
    def isRectangleOverlap(self, rec1, rec2):
        """
        :type rec1: List[int]
        :type rec2: List[int]
        :rtype: bool
        """
        w = self.overlap(rec1[0], rec1[2], rec2[0], rec2[2])
        h = self.overlap(rec1[1], rec1[3], rec2[1], rec2[3])
        return w * h > 0

    def overlap(self, low1, high1, low2, high2):
        low = max(low1, low2)
        high = min(high1, high2)
        if low >= high: 
            return 0
        return high - low