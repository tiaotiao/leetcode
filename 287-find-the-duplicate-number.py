
class Solution:
    def findDuplicate(self, nums):
        return self.cycleSolution(nums)

    # solution 2: find cycle O(n^2)
    def cycleSolution(self, nums):
        for i in range(len(nums)):
            trap = self.detectTrap(nums, i)
            if trap == None:
                continue
            return nums[trap]

    def detectTrap(self, nums, start):
        idx = self.findCycle(nums, start)

        count = self.countCycle(nums, idx)

        fast = self.step(nums, start, count)
        slow = start
        prev = None
        while True:
            if fast == slow:
                return prev
            prev = slow
            fast = self.step(nums, fast, 1)
            slow = self.step(nums, slow, 1)


    def countCycle(self, nums, start):
        idx = start
        n = 1
        while True:
            idx = self.step(nums, idx, 1)
            if idx == start:
                return n
            n += 1

    def findCycle(self, nums, start):
        fast, slow = start, start
        while True:
            fast = self.step(nums, fast, 2)
            slow = self.step(nums, slow, 1)
            if fast == slow:    # find a cycle here
                return slow
        return None
    
    def step(self, nums, idx, k):
        for _ in range(k):
            idx = nums[idx] - 1
        return idx

    # solution 1: binary search O(nlogn)
    def binarySearchSolution(self, nums):
        n = len(nums)
        if n <= 1:
            return None
        low = 1
        high = n - 1
        while low < high:
            mid = (low + high) // 2
            # count nums which <= mid
            count = 0
            for num in nums:
                if num <= mid:
                    count += 1
            
            if count > mid:    # duplicate must be in the lower side
                high = mid
            else:
                low = mid + 1
        return low



# ------------------------------------------------

def main():
    s = Solution()
    # nums = [3,1,1,1,4]
    nums = [3,2,2,2,4]
    # nums = [2,5,9,6,9,3,8,9,7,1]

    print(s.findDuplicate(nums))

if __name__ == '__main__':
    main()