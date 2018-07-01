
class Solution:
    def matrixScore(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """

        for i in range(len(A)):
            row = A[i]
            if row[0] == 0:
                self.flipRow(A, i)

        for j in range(len(A[0])):
            zeros, ones = self.countColZeros(A, j)
            if zeros > ones:
                self.flipCol(A, j)
        
        return self.sum(A)

    def countColZeros(self, A, j):
        zeros, ones = 0, 0
        for i in range(len(A)):
            if A[i][j] == 0:
                zeros += 1
            else:
                ones += 1
        return zeros, ones

    def flipRow(self, A, i):
        m = len(A[i])
        for j in range(m):
            self.flip(A, i, j)

    def flipCol(self, A, j):
        n = len(A)
        for i in range(n):
            self.flip(A, i, j)
            
    def flip(self, A, i, j):
        if A[i][j] == 0:
            A[i][j] = 1
        else:
            A[i][j] = 0

    def sum(self, A):
        s = 0
        for row in A:
            s += self.interprete(row)
        return s
        
    def interprete(self, row):
        num = 0
        for v in row:
            num = num * 2 + v
        return num