
import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3) return false;
        
        for (int i = 1; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (verify(num, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean verify(String num, int a, int b, int c) {
        if (a >= b || b >= c) return false;
        if (c == num.length()) return true;
        
        BigInteger x = null, y = null;
        try {
            x = toNumber(num, a, b);
            y = toNumber(num, b, c);
        } catch (Exception e) {
        }
        
        if (x == null || y == null) return false;
        BigInteger z = x.add(y);
        
        String next = z.toString();
        int d = c + next.length();
        
        if (d > num.length()) return false;
        if (!next.equals(num.substring(c, d))) return false;
        
        return verify(num, b, c, d);
    }
    
    private BigInteger toNumber(String num, int a, int b) {
        String s = num.substring(a, b);
        BigInteger v = new BigInteger(s);
        if (!s.equals(v.toString())) return null;
        return v;
    }
    
    
}