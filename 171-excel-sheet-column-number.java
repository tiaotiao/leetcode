

class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            int a = charToInt(c);
            num *= 26;
            num += a;
        }
        return num;
    }

    private int charToInt(char c) {
        return c - 'A' + 1;
    }
}