
import random

class Solution:
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        n = len(nums)
        if n == 0:
            return None
        if n <= 1:
            return nums[0]

        left, right = 0, n - 1

        p = random.randint(left, right)
        nums[right], nums[p] = nums[p], nums[right]

        val = nums[right]
        while left < right:
            while left < right and  val < nums[left]:
                left += 1
            if left < right:
                nums[right] = nums[left]
                right -= 1

            while left < right and nums[right] < val:
                right -= 1
            if left < right:
                nums[left] = nums[right]
                left += 1

        nums[left] = val
        
        # print(left, k, nums, val)
        if left == k - 1:
            return nums[left]
        if k - 1 < left:
            return self.findKthLargest(nums[:left], k)
        return self.findKthLargest(nums[left+1:], k - left - 1)

    # ---------------------------------------------------------------

    def quickSort(self, nums, start, end):
        n = len(nums)
        if n <= 1:
            return
        if end - start < 1:
            return 

        left, right = start, end

        p = random.randint(left, right)
        nums[right], nums[p] = nums[p], nums[right]

        val = nums[right]
        while left < right:
            while left < right and  val < nums[left]:
                left += 1
            if left < right:
                nums[right] = nums[left]
                right -= 1

            while left < right and nums[right] < val:
                right -= 1
            if left < right:
                nums[left] = nums[right]
                left += 1

        nums[left] = val

        self.quickSort(nums, start, left - 1)
        self.quickSort(nums, left + 1, end)


def main():
    s = Solution()

    nums = [2,5,1,3,7,4,6]

    print(s.findKthLargest(nums, 3))

    print(nums)

if __name__ == '__main__':
    main()