
class Solution:
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        ip, results = [], []

        self.addDot(s, 4, ip, results)

        return results
        
    def addDot(self, s, remain, ip, results):
        if remain <= 0:
            if len(s) > 0:
                return
            results.append(".".join(ip[:]))
            return
        
        # cut off branches
        if len(s) > remain * 3:
            return
        if len(s) < remain:
            return

        maxLen = min(3, len(s))

        for digits in range(1, maxLen + 1):
            sub = s[:digits]
            if not self.isValid(sub):
                continue
            ip.append(sub)
            self.addDot(s[digits:], remain - 1, ip, results)
            ip.pop()

    def isValid(self, s):
        if len(s) <= 0 or 3 < len(s):
            return False
        if len(s) > 1 and s[0] == "0":
            return False
        num = int(s)
        if 0 <= num and num <= 255:
            return True
        return 
        

def main():
    s = Solution()

    print(s.restoreIpAddresses("010010"))

if __name__ == '__main__':
    main()