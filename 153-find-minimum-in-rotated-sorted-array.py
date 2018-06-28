
class Solution:
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.findMinBinary(nums, 0, len(nums)-1)
        
    def findMinBinary(self, nums, left, right):
        print("binary", left, right)

        if left + 1 == right:   # only two nums
            return min(nums[left], nums[right])

        if left >= right:       # only one num
            return nums[left]
        
        mid = (left + right) // 2
        
        if nums[left] <= nums[mid] and nums[mid] <= nums[right]:    # in ascending order
            return nums[left]
        
        if nums[left] < nums[mid]:  # the peak is on the right side
            return self.findMinBinary(nums, mid, right)
        
        return self.findMinBinary(nums, left, mid)  # the peak is on the left side


def main():
    s = Solution()
    print(s.findMin([4,5,6,1,2,3]))

if __name__ == '__main__':
    main()