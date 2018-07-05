class Solution:
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        self.onePassSort(nums)

    def onePassSort(self, nums):
        left, right = 0, len(nums) - 1
        i = 0
        while i <= right:
            num = nums[i]
            if num == 0:
                nums[left], nums[i] = nums[i], nums[left]
                left += 1
                i += 1
            elif num == 1:
                i += 1
            else:   # num == 2
                nums[right], nums[i] = nums[i], nums[right]
                right -= 1

        
        
    def countingSort(self, nums):
        count = [0, 0, 0]
        for num in nums:
            count[num] += 1
        i = 0
        for num in range(0, 3):
            for _ in range(0, count[num]):
                nums[i] = num
                i += 1


def main():
    s = Solution()

    nums = [2,0,1]

    s.sortColors(nums)

    print(nums)

if __name__ == '__main__':
    main()