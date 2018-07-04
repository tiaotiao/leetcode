
class Solution:
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        robCurr = 0
        robPrev = 0
        robPrePrev = 0

        for num in nums:
            # print(num, robCurr, robPrev, robPrePrev)
            curr = num + max(robPrev, robPrePrev)
            prev = robCurr
            prevprev = robPrev

            robCurr = curr
            robPrev = prev
            robPrePrev = prevprev
        return max(robCurr, robPrev)


def main():
    s = Solution()

    nums = [2, 1, 1, 2]

    print(s.rob(nums))

if __name__ == '__main__':
    main()
