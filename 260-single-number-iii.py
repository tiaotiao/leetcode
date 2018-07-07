
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        x = 0
        for num in nums:
            x ^= num
        
        d = x & ~(x-1)  # the lowest bit

        a, b = 0, 0
        for num in nums:
            if num & d:
                a ^= num
            else:
                b ^= num
        return [a,b]

def main():
    s = Solution()

    nums = [1,2,1,3,2,5]

    print(s.singleNumber(nums))

if __name__ == '__main__':
    main()