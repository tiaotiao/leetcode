

class Solution:
    def findLength(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        
        n = len(A)
        m = len(B)
        if n == 0 or m == 0:
            return 0
        
        # dp[i][j] = dp[i-1][j-1] + 1, if A[i] == B[j]
        #          = 0,                if A[i] != B[j]
        maximum = 0
        dp = [0] * m
        for i in range(n):
            for j in range(m-1, -1, -1):
                if A[i] == B[j]:
                    if j == 0: dp[j] = 1
                    else: dp[j] = dp[j-1] + 1
                    maximum = max(dp[j], maximum)
                else:
                    dp[j] = 0

        return maximum


def main():
    s = Solution()
    A = [1,2,3,2,1]
    B = [3,2,1,4,7]

    print(s.findLength(A, B))

if __name__ == '__main__':
    main()