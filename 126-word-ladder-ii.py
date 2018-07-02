
import string

class Solution:

    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        
        # init
        self.wordList = wordList
        self.neighbors = {}
        self.distances = {}
        self.paths = {}
        self.wordSet = set()
        for w in wordList:
            self.wordSet.add(w)

        # bfs
        currLevel = {beginWord}
        nextLevel = set()
        dist = 1
        self.distances[beginWord] = 0
        self.paths[beginWord] = [[beginWord]]
        isEnd = False

        while len(currLevel) > 0:
            dist += 1
            for word in currLevel:  # start from word
                s = self.getNeighbors(word)
                for w in s:         # visit all neighbors
                    d = self.getDistance(w)
                    if d != None and d < dist:
                        continue
                    if w == endWord:
                        isEnd = True
                    nextLevel.add(w)
                    self.distances[w] = dist
                    newPaths = []
                    if w in self.paths:
                        newPaths = self.paths[w]
                    for path in self.paths[word]:
                        newPath = path[:]
                        newPath.append(w)
                        newPaths.append(newPath)
                    self.paths[w] = newPaths
            # print(nextLevel)
            if isEnd:
                break
            # prepare for next level
            currLevel = nextLevel
            nextLevel = set()

        # result
        if endWord not in self.distances:
            return []
        return self.paths[endWord]

    def getDistance(self, word):
        if word in self.distances:
            return self.distances[word]
        return None

    def getNeighbors(self, word):
        if word in self.neighbors:
            return self.neighbors[word]
        
        s = self.getNeighbors_construct(word)

        self.neighbors[word] = s
        return s

    def getNeighbors_search(self, word):
        s = []
        for w in self.wordList:
            if self.canTransform(word, w):
                s.append(w)
        return s

    def getNeighbors_construct(self, word):
        s = []
        ws = list(word)
        for i in range(len(ws)):
            original = ws[i]
            for ch in tuple(string.ascii_lowercase):
                if ch == original:
                    continue
                ws[i] = ch
                newWord = "".join(ws)
                if newWord in self.wordSet:
                    s.append(newWord)
            ws[i] = original
        return s

    def canTransform(self, w, u):
        if len(w) != len(u):
            return False
        count = 0
        for i in range(len(w)):
            if w[i] != u[i]:
                count += 1
        return count == 1
        

def main():
    s = Solution()
    
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]
    
    ladders = s.findLadders(beginWord, endWord, wordList)

    print(ladders)

if __name__ == '__main__':
    main()