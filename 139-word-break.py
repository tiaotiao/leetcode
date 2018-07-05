
class Solution:
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """

        words = set(wordDict)
        return self.breakdown(s, words, {})
        
    def breakdown(self, s, words, visited):
        if len(s) == 0:
            return True
        if s in visited:
            return visited[s]

        for i in range(len(s)):
            word = s[:i+1]
            if word not in words:
                continue
            remain = s[i+1:]
            ok = self.breakdown(remain, words, visited)
            visited[remain] = ok
            if ok:
                return True
        return False


def main():
    s = Solution()

    st = "catsandog"
    dic = ["cats", "dog", "sand", "and", "cat"]

    print(s.wordBreak(st, dic))

if __name__ == '__main__':
    main()
