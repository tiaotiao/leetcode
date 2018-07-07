
class Solution:
    # num   1   1   1 
    # ones  0   1   0
    # twos  1   0   0
    #----------------
    # ones  0   0   1
    # twos  1   0   0
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ones, twos = 0, 0
        for num in nums:
            ones = (ones ^ num) & ~twos 
            twos = (twos ^ num) & ~ones
        return ones


def main():
    s = Solution()

    nums = [2,2,3,2]

    print(s.singleNumber(nums))

if __name__ == '__main__':
    main()