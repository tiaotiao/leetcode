
class Solution:
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        lenA = len(A)
        lenB = len(B)

        if lenB == 0: return 0
        if lenA == 0: return -1
            
        repeats = lenB // lenA
        # if lenB % lenA > 0:
        #     repeats += 1
        
        C = A * repeats
        while True:
            if C.find(B) != -1:
                return repeats
            if len(C) > lenA + lenB:
                break
            C += A
            repeats += 1
        return -1
        
def main():
    s = Solution()

    A = "abababaaba"
    B = "aabaaba"

    print(s.repeatedStringMatch(A, B))

if __name__ == '__main__':
    main()