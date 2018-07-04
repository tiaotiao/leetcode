
class Solution:
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums)
        if n <= 0:
            return 0
        if n == 1:
            return nums[0]

        # p[0][i] not rob the first house
        # p[1][i] rob the first house
        p = [[], []]

        # rob the i th house
        for i in range(0, n):
            for k in range(2):
                p[k].append(0)
                if k == 0 and i == 0:
                    continue
                if k == 1 and i == 1:
                    continue
                if k == 1 and i == n -1:
                    continue
                for j in range(2):
                    # rob the prev house
                    prev = i - j - 2
                    if prev < 0:
                        continue
                    
                    p[k][i] = max(p[k][i], p[k][prev])
                p[k][i] += nums[i]

        # print(p)
        maximum = 0
        for k in range(2):
            for j in range(3):
                if j >= n:
                    continue
                maximum = max(maximum, p[k][-1 - j])
        return maximum


def main():
    s = Solution()
    
    # nums = [2,3,2]
    # nums = [1,2,3,1]
    nums = [2,7,9,3,1]
    
    print(nums)

    print(s.rob(nums))

if __name__ == '__main__':
    main()