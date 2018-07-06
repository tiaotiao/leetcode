
class Solution:
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2:
            return 0
        primes = self.generatePrimes2(n)
        # print(primes)
        return len(primes)

    # ------------- AC: O(n * sqrt(n)) -----------------
    def generatePrimes2(self, n):
        p = [True for i in range(n)]
        p[0] = False
        p[1] = False
        primes = []
        for i in range(2, n):
            if not p[i]: 
                continue
            primes.append(i)
            k = 2
            while i * k < n:
                p[i * k] = False
                k += 1
        return primes
    
    # ------------ time limited exceeded, O(n * numPrimes(n)) -------------
    def generatePrimes(self, n):
        if n == 0 or n == 1:
            return []
        
        primes = []
        for i in range(2, n):
            if self.isPrime(i, primes):
                primes.append(i)
        return primes

    def isPrime(self, n, primes):
        for p in primes:
            if n % p == 0:
                return False
            if p * p > n:   # ****
                break
        return True


def main():
    s = Solution()

    print(s.countPrimes(10))

if __name__ == '__main__':
    main()