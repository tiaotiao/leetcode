
class Solution {
    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if ('A' <= cs[i] && cs[i] <= 'Z') {
                cs[i] = (char)(cs[i] - 'A' + 'a');
            }
        }
        return new String(cs);
    }
}