
class Solution:
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums, combs = [], []
        visited = set()

        self.combine(candidates, 0, target, nums, combs, visited)

        return combs
        
    def combine(self, candidates, index, target, nums, combs, visited):
        if target == 0:
            c = nums[:]
            c.sort()
            s = tuple(c)
            if s in visited:
                return
            visited.add(s)
            combs.append(c)
            return
        if target < 0:
            return
        if index >= len(candidates):
            return
        
        self.combine(candidates, index + 1, target, nums, combs, visited)

        num = candidates[index]
        nums.append(num)
        self.combine(candidates, index + 1, target - num, nums, combs, visited)
        nums.pop()

        
def main():
    s = Solution()

    cand = [10,1,2,7,6,1,5]
    target = 8

    print(s.combinationSum2(cand, target))

if __name__ == '__main__':
    main()