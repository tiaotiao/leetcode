

class Solution:
    def reorderedPowerOf2(self, N):
        """
        :type N: int
        :rtype: bool
        """
        
        if N == 0:
            return False

        digits, counts = self.getDigits(N)
        n = len(digits)

        p2 = 1
        while True:
            ds, cs = self.getDigits(p2)
            m = len(ds)
            if m < n:
                p2 *= 2
                continue
            if m > n:
                break

            # contain the same nums
            same = True
            for d in digits:
                if d not in cs:
                    same = False
                    break
                if counts[d] != cs[d]:
                    same = False
                    break
            if same:
                return True

            p2 *= 2

        return False


    def getDigits(self, N):
        digits = []
        counts = {}
        while N > 0:
            d = N % 10
            N //= 10
            digits.append(d)
            if d not in counts:
                counts[d] = 1
            else:
                counts[d] += 1

        return digits, counts

def main():
    s = Solution()

    N = 46
    print(s.reorderedPowerOf2(N))

if __name__ == '__main__':
    main()