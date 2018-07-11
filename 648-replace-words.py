
class Node:
    def __init__(self):
        self.word = None
        self.child = {}     # child['a'] = childNode

class Trie:
    def __init__(self):
        self.root = Node()
    
    def insert(self, word):
        chs = list(word)
        node = self.root
        
        for c in chs:
            if c not in node.child:
                node.child[c] = Node()
            node = node.child[c]
        node.word = word

    def prefix(self, word):
        chs = list(word)
        node = self.root

        for c in chs:
            if c not in node.child:
                return None
            node = node.child[c]
            if node.word:
                return node.word
        return None

# ------------------------------------------------

class Solution:
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        
        trie = Trie()
        for d in dict:
            trie.insert(d)

        words = sentence.split()
        newwords = []

        for w in words:
            r = trie.prefix(w)
            if r == None:
                newwords.append(w)
            else:
                newwords.append(r)
        
        res = " ".join(newwords)

        return res



def main():
    s = Solution()

    d = ["cat", "bat", "rat"]
    sen = "the cattle was rattled by the battery"

    print(s.replaceWords(d, sen))

if __name__ == '__main__':
    main()