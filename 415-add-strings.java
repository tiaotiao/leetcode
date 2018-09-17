
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) return "";
        int len = Math.max(len1, len2);
        
        char[] c = new char[len + 1];
        
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int c1 = get(num1, i);
            int c2 = get(num2, i);
            
            int x = 0;
            if (c1 > 0) x += c1;
            if (c2 > 0) x += c2;
            
            c[i] = (char)(x + carry);
            if (c[i] >= 10) {
                c[i] -= 10;
                carry = 1;
            } else carry = 0;
            c[i] += '0';
        }
        
        if (carry > 0) c[len++] = (char)('0' + carry);
        
        // reverse
        for (int i = 0; i < len / 2; i++) {
            int j = len - i - 1;
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
        
        return new String(c, 0, len);
    }
    
    private int get(String s, int i) {
        if (i >= s.length()) return -1;
        return s.charAt(s.length() - i - 1) - '0';
    }
}