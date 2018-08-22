
import collections

class Solution:
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        return self.solve_deque(nums, k)

    def solve_deque(self, nums, k):
        dq = collections.deque(nums)
        dq.rotate(k)
        for i in range(len(nums)):
            num = dq.popleft()
            nums[i] = num

    def solve_cycle(self, nums, k):
        n = len(nums)
        if n == 0: return
        k = k % n
        if k == 0: return
        
        
        idx, start, count = 0, 0, 0
        val = nums[0]
        for _ in range(n):
            nextIdx = self.next(k, n, idx)
            nextVal = nums[nextIdx]
            print(nextIdx, nextVal)
            nums[nextIdx] = val
            if nextIdx == start:
                idx = start + 1
                start = idx
                val = nums[start]
            else:
                idx = nextIdx
                val = nextVal
        
    def next(self, k, n, idx):
        return (idx + k) % n


def main():
    s = Solution()

    nums = [1,2,3,4,5,6]
    k = 2

    s.rotate(nums, k)

    print(nums)

if __name__ == '__main__':
    main()