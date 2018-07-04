class Solution:
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        
        A = 0
        B = 0
        missed = {}
        wrongGuess = []
        for i in range(len(secret)):
            s = secret[i]
            g = guess[i]
            if s == g:
                A += 1
            else:
                wrongGuess.append(g)
                c = 0
                if s in missed:
                    c = missed[s]
                missed[s] = c + 1

        for g in wrongGuess:
            c = 0
            if g in missed:
                c = missed[g]
            if c > 0:
                B += 1
                missed[g] = c - 1
        return "{}A{}B".format(A, B)

def main():
    s = Solution()
    secret = "1807"
    guess = "7810"
    print(s.getHint(secret, guess))

if __name__ == '__main__':
    main() 