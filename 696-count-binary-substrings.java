
class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0;
        int currCh = -1;
        int currCnt = 0;
        int prevCnt = 0;
        for (char c : s.toCharArray()) {
            if (currCh == -1 || currCh != c) {
                currCh = c;
                prevCnt = currCnt;
                currCnt = 0;
            }
            currCnt += 1;
            if (prevCnt > 0) {
                result += 1;
                prevCnt -= 1;
            }
        }
        return result;
    }
}