class Solution:
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        
        pt = list(pattern)
        ss = str.split(" ")
        if len(pt) != len(ss):
            return False
        if len(pt) <= 0:
            return False

        print(pt, ss)

        m = {}
        u = {}
        for i in range(len(pt)):
            p = pt[i]
            s = ss[i]
            if p not in m:
                m[p] = s
                if s in u:
                    return False
                u[s] = p
                continue
            print(s, m[p])
            if s != m[p]:
                return False
        return True

def main():
    solution = Solution()

    p = "abba"
    s = "dog dog dog dog"

    print(solution.wordPattern(p,s))

if __name__ == '__main__':
    main()