
class Solution:
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        # return self.trickySolution(num)

        if num < 10:
            return num
        
        s = 0
        while num > 0:
            s += num % 10
            num //= 10

        return self.addDigits(s)

    def trickySolution(self, num):
        r = num % 9
        return r if r != 0 else 9

def main():
    s = Solution()
    
    nums = list(range(90))
    for num in nums:
        r = s.addDigits(num)
        print(num, r)

if __name__ == '__main__':
    main()