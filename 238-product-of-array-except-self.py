
class Solution:
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        return self.solveWithConstantSpace(nums)
        
    # --------- O(n) with O(1) space ----------
    def solveWithConstantSpace(self, nums):
        n = len(nums)
        output = [1] * n 

        fromLeft, fromRight = 1, 1
        for i in range(n):
            j = n-1-i
            output[i] *= fromLeft
            output[j] *= fromRight
            fromLeft *= nums[i]
            fromRight *= nums[j]

        return output

    # --------- O(n) with O(n) space ----------
    def solveWithPartialProductions(self, nums):
        n = len(nums)

        fromLeft = [0] * n
        fromRight = [0] * n

        left, right = 1, 1
        for i in range(n):
            fromLeft[i] = left
            fromRight[n-1-i] = right
            left = left * nums[i]
            right = right * nums[n-1-i]

        output = []
        for i in range(n):
            p = fromLeft[i] * fromRight[i]
            output.append(p)
        return output

def main():
    s = Solution()

    nums = [1,2,4,6]

    print(s.productExceptSelf(nums))

if __name__ == '__main__':
    main()
        