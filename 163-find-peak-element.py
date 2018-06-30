

class Solution:
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if nums == None or len(nums) == 0:
            return None

        left = 0
        right = len(nums)-1
        while left < right:
            mid = (left + right) // 2
            leftSmaller, rightSmaller = self.neighbors(nums, mid)
            # print(left, mid, right, leftSmaller, rightSmaller)
            if leftSmaller and rightSmaller:
                return mid            
            if leftSmaller:
                left = mid + 1
            else:
                right = mid - 1
        return left

    def neighbors(self, nums, index):
        leftSmaller, rightSmaller = False, False
        if index == 0 or nums[index-1] < nums[index]:
            leftSmaller = True
        if index == len(nums)-1 or nums[index] > nums[index+1]:
            rightSmaller = True
        return leftSmaller, rightSmaller
    

def main():
    s = Solution()
    l = [1,2,1,3,5,6,4]
    print(s.findPeakElement(l))

if __name__ == '__main__':
    main()