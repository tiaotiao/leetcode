
class Solution:
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        for i in range(len(nums)):  
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] = -nums[idx]
            else:
                res.append(idx + 1)
        return res

def main():
    s = Solution()
    nums = [4,3,2,7,8,2,3,1]
    print(s.findDuplicates(nums))

if __name__ == '__main__':
    main()