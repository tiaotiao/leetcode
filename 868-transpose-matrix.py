
class Solution:
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        
        if not A: return None
        n = len(A)
        if n == 0: return []
        m = len(A[0])
        if m == 0: return [[]]

        B = [[None for i in range(n)] for j in range(m)]

        for i in range(n):
            for j in range(m):
                B[j][i] = A[i][j]
        return B
