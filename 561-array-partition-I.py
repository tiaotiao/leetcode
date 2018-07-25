
class Solution:
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        s = 0
        for i in range(len(nums)//2):
            s += nums[i * 2]
        return s

def main():
    s = Solution()
    nums = [1,4,3,2]
    print(s.arrayPairSum(nums))

if __name__ == '__main__':
    main()