


class Solution:
    def checkSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        n = len(nums)
        if n == 0: return False
        if k < 0: k = -k


        sums = {0:-1}
        s = 0
        for i in range(len(nums)):
            s += nums[i]
            if k != 0: s %= k
            # print(i, nums[i], s, sums)
            if s in sums:
                j = sums[s]
                if i - j > 1: 
                    return True
            else: sums[s] = i

        return False


def main():
    s = Solution()
    nums = [0,0]
    k = 0
    print(s.checkSubarraySum(nums, k))

if __name__ == '__main__':
    main()