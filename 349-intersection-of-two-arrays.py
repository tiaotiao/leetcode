

class Solution:
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        return list(set(nums1) & set(nums2)) 


def main():
    s = Solution()

    a = [4,9,5]
    b = [9,4,9,8,4]

    print(s.intersection(a, b))

if __name__ == '__main__':
    main()