

class Solution:
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        
        if len(nums) == 0: return []
        
        ranges = []
        start = nums[0]
        expect = start

        for num in nums:
            if num == expect:
                expect += 1
                continue
            
            r = str(start)
            if start < expect - 1:
                r = "{}->{}".format(start, expect - 1)
            ranges.append(r)

            start = num
            expect = start + 1

        r = str(start)
        if start < expect - 1:
            r = "{}->{}".format(start, expect - 1)
        ranges.append(r)

        return ranges

def main():
    s = Solution()

    nums = [0,2,3,4,6,8,9]  

    print(s.summaryRanges(nums))

if __name__ == '__main__':
    main()