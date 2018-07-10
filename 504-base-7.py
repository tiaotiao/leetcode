
class Solution:
    def convertToBase7(self, num):
        """
        :type num: int
        :rtype: str
        """

        if num == 0:
            return "0"
        
        sign = 1
        if num < 0:
            sign = -1
            num = -num
        
        ss = []
        
        while num > 0:
            r = num % 7
            num //= 7
            ss.append(str(r))

        ss.reverse()

        s = "".join(ss)
        if sign == -1:
            s = "-" + s
        return s


def main():
    s = Solution()
    num = -9
    print(s.convertToBase7(num))


if __name__ == '__main__':
    main()

