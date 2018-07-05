
import string

class Solution:
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        chars = list(S)
        perms = []
        self.generatePerms(chars, 0, perms)
        return perms

    
    def generatePerms(self, chars, index, perms):
        if index >= len(chars):
            perms.append("".join(chars[:]))
            return

        ch = chars[index]
        if ch not in string.ascii_letters:
            self.generatePerms(chars, index + 1, perms)
        else:
            chars[index] = ch.lower()
            self.generatePerms(chars, index + 1, perms)
            chars[index] = ch.upper()
            self.generatePerms(chars, index + 1, perms)
        
def main():
    s = Solution()
    S = "a1b2"
    print(s.letterCasePermutation(S))

if __name__ == '__main__':
    main()