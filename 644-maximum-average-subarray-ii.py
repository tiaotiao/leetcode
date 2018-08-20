

class Solution:
    """
    @param: nums: an array with positive and negative numbers
    @param: k: an integer
    @return: the maximum average
    """
    def maxAverage(self, nums, k):
        # write your code here
        n = len(nums)
        if n < k: return 0

        prefix = self.maxPrefixAverage(nums)
        suffix = self.maxPrefixAverage(list(reversed(nums)))

        left = 0
        sums = 0
        avgs = 0
        max_avg = None
        for right in range(n):
            sums += nums[right]
            if right - left + 1 < k:
                continue
            if right - left + 1 > k:
                sums -= nums[left]
                left += 1
            avgs = sums / k

            avgs, l = self.addPrefix(prefix, avgs, left, k)
            avgs, r = self.addPrefix(suffix, avgs, n - right - 1, k + left - l)

            if max_avg is None or max_avg < avgs:
                max_avg = avgs
        return max_avg


    def maxPrefixAverage(self, nums):
        prefix = [(nums[0], 0)]     # List[(max_avg, start_idx)]
        
        for i in range(1, len(nums)):
            avg, start = self.addPrefix(prefix, nums[i], i, 1)
            prefix.append((avg, start))
        return prefix

    def addPrefix(self, prefix, avg, start, count):
        index = start
        while start > 0:
            avg_prev, start_prev = prefix[start - 1]
            if avg_prev <= avg:
                break
            avg = (avg * (index - start + count) + avg_prev * (start - start_prev)) / (index - start_prev + count)
            start = start_prev
        return avg, start


def main():
    s = Solution()

    # nums = [1, 12, -5, -6, 50, 3]
    # k = 3
    nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-15,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
    k = 30

    print(s.maxAverage(nums, k))

if __name__ == '__main__':
    main()