
class Solution:
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        words = set(wordDict)
        return self.generateSentences(s, words, {})
        
    def generateSentences(self, s, words, visited):
        if s == "":
            return [""]
        if s in visited:
            return visited[s]

        sentences = []

        for i in range(len(s)):
            w = s[:i+1]
            r = s[i+1:]
            if w not in words:
                continue
            
            ss = self.generateSentences(r, words, visited)
            ss = ss[:]
            
            for i in range(len(ss)):
                st = ss[i]
                if st == "":
                    st = w
                else:
                    st = w + " " + st
                ss[i] = st

            sentences.extend(ss)

        visited[s] = sentences

        return sentences


def main():
    s = Solution()

    st = "pineapplepenapple"
    d = ["apple", "pen", "applepen", "pine", "pineapple"]

    print(s.wordBreak(st, d))

if __name__ == '__main__':
    main()