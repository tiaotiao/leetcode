# https://leetcode.com/problems/first-unique-character-in-a-string/description/

# Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

# Examples:

# s = "leetcode"
# return 0.

# s = "loveleetcode",
# return 2.
# Note: You may assume the string contain only lowercase letters.

class Solution:
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        if n == 0: return -1

        letters = {}
        
        for i in range(n):
            c = s[i]
            if c not in letters:
                letters[c] = i
            else:
                letters[c] = n

        r = min(letters.values())
        if r == n: return -1
        return r
