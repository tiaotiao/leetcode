
class Solution:
    def binaryGap(self, N):
        """
        :type N: int
        :rtype: int
        """
        
        maxDist = 0
        prev = None
        i = 0
        while N > 0:
            i += 1
            b = N & 1
            N >>= 1
            if b == 0:
                continue
            
            if prev == None:
                prev = i
                continue
            
            dist = i - prev
            if maxDist < dist:
                maxDist = dist

            prev = i
        
        return maxDist

def main():
    s = Solution()
    print(s.binaryGap(22))

if __name__ == '__main__':
    main()