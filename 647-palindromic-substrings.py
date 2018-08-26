

class Solution:
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        count = 0
        for i in range(len(s)):
            count += 1
            for j in range(min(i, len(s) - i - 1)):
                if s[i-j-1] != s[i+j+1]:
                    break
                count += 1
            for j in range(min(i, len(s) - i)):
                if s[i-j-1] != s[i+j]:
                    break
                count += 1
        return count

def main():
    s = Solution()
    st = "aaaa"
    print(s.countSubstrings(st))

if __name__ == '__main__':
    main()