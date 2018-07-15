

class Solution:
    def advantageCount(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """

        n = len(A)
        if n == 0:
            return []

        pairsB = [(B[i], i) for i in range(len(B))]
        pairsB.sort(key = lambda x: x[0])
        A.sort()

        wins = []
        loss = []

        i, j = 0, 0

        while i < n:
            a, b = A[i], pairsB[j][0]
            i += 1

            if a > b:
                wins.append(a)
                j += 1
            else:
                loss.append(a)
        
        nums = wins + loss

        shuffle = [0] * n
        i = 0
        for _, idx in pairsB:
            shuffle[idx] = nums[i]
            i += 1

        return shuffle

def main():
    s = Solution()

    A = [12,24,8,32]
    B = [13,25,32,11]

    print(s.advantageCount(A, B))

if __name__ == '__main__':
    main()



