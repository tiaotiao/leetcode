

class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length-1; i<j; i++, j--) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
        }
        return String.valueOf(c);
    }
}

