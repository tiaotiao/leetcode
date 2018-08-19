

class Solution:
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        total = sum(nums)
        s = 0
        for i in range(len(nums)):
            if (total - nums[i]) % 2 != 0:
                s += nums[i]
                continue 
            half = (total - nums[i]) // 2
            if s == half:
                return i
            s += nums[i]
        return -1


def main():
    s = Solution()
    nums = [1,7,3,6,5,6]
    print(s.pivotIndex(nums))

if __name__ == '__main__':
    main()