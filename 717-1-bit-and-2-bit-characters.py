
class Solution:
    def isOneBitCharacter(self, bits):
        """
        :type bits: List[int]
        :rtype: bool
        """
        n = len(bits)
        
        if n <= 0: return False

        i = 0
        size = 0
        while i < n:
            if bits[i] == 0:
                size = 1
            if bits[i] == 1:
                size = 2
            i += size
        return size == 1

def main():
    s = Solution()

    bits = [1, 0, 0]

    print(s.isOneBitCharacter(bits))

if __name__ == '__main__':
    main()