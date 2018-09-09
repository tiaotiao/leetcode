class Solution:
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.solve_two_pointers(nums)
        
    def solve_two_pointers(self, nums):
        n = len(nums)
        if n == 0: return None

        product = 1
        maximum = max(nums)
        left, right = 0, 0

        while right <= n:
            # print(left, right, product, maximum)         
            if right == n or nums[right] == 0:
                while left < right-1:
                    product //= nums[left]
                    if maximum < product:
                        maximum = product
                    left += 1
                product = 1
                left = right + 1
                right += 1
                continue

            product *= nums[right]
            if maximum < product:
                maximum = product
            right += 1
        return maximum

def main():
    s = Solution()
    nums = [-2,0,-1]
    print(s.maxProduct(nums))

if __name__ == '__main__':
    main()