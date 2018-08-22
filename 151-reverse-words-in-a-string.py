
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        words = s.split()
        words.reverse()
        return " ".join(words)


def main():
    s = Solution()

    st = "  the  sky is    blue "
    print(s.reverseWords(st))

if __name__ == '__main__':
    main()