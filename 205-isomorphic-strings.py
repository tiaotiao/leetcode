class Solution:
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        n = len(s)
        if len(s) != len(t):
            return False
        if n == 0:
            return True
        
        m = {}
        u = {}
        for i in range(n):
            startCh = s[i]
            targetCh = t[i]

            if not startCh in m:
                if targetCh in u:
                    return False
                m[startCh] = targetCh
                u[targetCh] = startCh
                continue

            target = m[startCh]
            if targetCh != target:
                return False

        return True
        