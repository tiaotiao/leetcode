
class Solution:
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        
        # the last increasing number from the end
        k = -1
        for i in range(len(nums)-1, 0, -1):
            if nums[i-1] < nums[i]:
                k = i-1
                break

        if k == -1:
            nums[:] = reversed(nums)
            return

        # fint the least num which larger than num[k]
        leastLarger = k + 1
        for i in range(k+1, len(nums)):
            if nums[k] < nums[i] and nums[i] <= nums[leastLarger]:
                leastLarger = i

        # swap k and leastLarger
        nums[k], nums[leastLarger] = nums[leastLarger], nums[k]

        nums[k+1:] = reversed(nums[k+1:])


def main():
    s = Solution()

    nums = [3,2,1]
    s.nextPermutation(nums)
    print(nums)

if __name__ == '__main__':
    main()