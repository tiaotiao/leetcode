
from collections import Counter

class Solution:
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        return self.solve_sorted(nums1, nums2)

    def solve_sorted(self, nums1, nums2):
        nums1.sort()
        nums2.sort()

        res = []
        i, j = 0, 0
        while i < len(nums1) and j < len(nums2):
            a = nums1[i]
            b = nums2[j]
            if a > b:
                j += 1
            elif a < b:
                i += 1
            else:
                res.append(a)
                i += 1
                j += 1
        return res

    def solve_dict(self, nums1, nums2):
        
        c1 = Counter(nums1)
        c2 = Counter(nums2)

        common = c1.keys() & c2.keys()

        return list(Counter(dict(map(lambda k: (k, min(c1[k], c2[k])), common))).elements())


def main():
    s = Solution()

    a = [1,2,2,1]
    b = [2,2]

    print(s.intersect(a,b))

if __name__ == '__main__':
    main()