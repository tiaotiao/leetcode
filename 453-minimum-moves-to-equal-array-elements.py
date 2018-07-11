

class Solution:
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return sum(nums) - min(nums) * len(nums)



def main():
    s = Solution()
    nums = [1,2,3,3,4]
    print(s.minMoves(nums))

if __name__ == '__main__':
    main()