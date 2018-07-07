

class Solution:
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.solve2(nums)
        
    # O(n) math
    def solve2(self, nums):
        s = sum(nums)
        n = len(nums)
        expect = n*(n+1) // 2
        return expect - s

    # O(n) swap
    def solve1(self, nums):
        nums.append(-1)

        for i in range(len(nums)):
            num = nums[i]
            while num != -1 and nums[num] != num:
                nextNum = nums[num]
                nums[num] = num
                num = nextNum
            nums[i] = num
        # print(nums)
        for i in range(len(nums)):
            if nums[i] == -1:
                return i
        
def main():
    s = Solution()

    # nums = [3,0,1]
    nums = [9,6,4,2,3,5,7,0,1]
    print(s.missingNumber(nums))

if __name__ == '__main__':
    main()

            