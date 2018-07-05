

class Solution:
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums, combs = [], []

        self.combine(candidates, 0, target, nums, combs)

        return combs
        
    def combine(self, candidates, index, target, nums, combs):
        # print("combine", index, target, nums)
        if target == 0:
            # found a combination
            comb = nums[:]
            combs.append(comb)
            return
        if index >= len(candidates):
            return
        if target < 0:
            return
        
        num = candidates[index]
        m = target // num + 1
        for i in range(m):
            if i > 0:
                nums.append(num)
                target -= num
            self.combine(candidates, index + 1, target, nums, combs)
        for i in range(m - 1):
            nums.pop()
        

def main():
    s = Solution()

    candidates = [2,3,5]
    target = 8

    print(s.combinationSum(candidates, target))

if __name__ == '__main__':
    main()
        
