
class Solution:
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        
        n = len(s)
        m = len(t)
        if n <= 0 or n < m:
            return ""

        left = 0
        right = 0
        length = 0
        result = ""

        chars = {}
        expect = {}
        for ch in t:
            chars[ch] = 0
            if ch not in expect:
                expect[ch] = 1
            else:
                expect[ch] += 1
        
        count = 0
        while right < n:
            # extend to right until all chars in t are covered
            # print("extend", left, right)
            while right < n:
                ch = s[right]
                right += 1
                
                if ch not in chars:
                    continue
                chars[ch] += 1
                if chars[ch] == expect[ch]:
                    count += 1

                if count == len(chars):  # coverd all chars
                    break

            if count < len(chars):
                # print(left, right, "count", count, "<", len(chars))
                break

            # shrink from left until not all chars are covered
            # print("shrink", left, right)
            while left < right:
                if length == 0 or length > right - left:
                    length = right - left
                    result = s[left:right]
                    # print(left, right, result)

                ch = s[left]
                left += 1

                if ch not in chars:
                    continue

                if chars[ch] == expect[ch]:
                    count -= 1
                chars[ch] -= 1
                if count < len(chars):
                    break

        return result


def main():
    s = Solution()

    S = "ADOBECODEBANC"
    T = "ABC"

    print(s.minWindow(S, T))

if __name__ == '__main__':
    main()