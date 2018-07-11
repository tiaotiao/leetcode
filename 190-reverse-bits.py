# https://leetcode.com/problems/reverse-bits/description/

# Reverse bits of a given 32 bits unsigned integer.

# Example:

# Input: 43261596
# Output: 964176192
# Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
#              return 964176192 represented in binary as 00111001011110000010100101000000.
# Follow up:
# If this function is called many times, how would you optimize it?


class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        self.buildCache()
        return self.fromCache(n)

    def fromCache(self, n):
        m = 0
        mask = 0xFF
        offset = 0
        for _ in range(4):
            r = self.cache[n & mask]
            m |= r >> offset
            offset += 8
            n >>= 8
        return m

    def buildCache(self):
        if hasattr(self, 'cache'):
            return
        self.cache = {}
        for i in range(1<<8):
            r = self.reverse(i)
            self.cache[i] = r

    def reverse(self, n):
        m = 0
        for _ in range(32):
            m <<= 1
            m += n & 1
            n >>= 1
        return m

def main():
    s = Solution()
    print(s.reverseBits(43261596))

if __name__ == '__main__':
    main()