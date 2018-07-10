

class Solution:
    def triangleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.solve1(nums)

    def solve1(self, nums):
        nums.sort()
        total = 0
        for i in range(len(nums)):
            k = i + 1
            for j in range(i+1, len(nums)):
                a = nums[i]
                b = nums[j]
                if k <= j:
                    k = j + 1

                while k < len(nums):
                    c = nums[k]
                    if a + b <= c:
                        break
                    print(a, b, c)
                    k += 1
                total += k - j - 1
        return total


def main():
    s = Solution()

    nums = [1,2,2,3,4,5]

    print(s.triangleNumber(nums))

if __name__ == '__main__':
    main()