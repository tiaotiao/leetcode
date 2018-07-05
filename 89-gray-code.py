
class Solution:
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        
        if n == 0:
            return [0]

        results = []
        code = [0 for i in range(n)]

        self.generate(code, 0, results)

        return results

    def generate(self, code, idx, results):
        if idx >= len(code):
            c = self.codeToNum(code)
            results.append(c)
            return

        self.generate(code, idx + 1, results)
        
        if code[idx] == 0:
            code[idx] = 1
        else:
            code[idx] = 0

        self.generate(code, idx + 1, results) 

    def codeToNum(self, code):
        num = 0
        for bit in code:
            num <<= 1
            num += bit
        return num
    

def main():
    s = Solution()

    print(s.grayCode(1))

if __name__ == '__main__':
    main()