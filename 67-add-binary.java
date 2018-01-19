
import java.util.*;

class Solution {
    
    private int[] toIntArray(String a) {
        int n = a.length();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '0') {
                x[n-1-i] = 0;
            } else {
                x[n-1-i] = 1;
            }
        }
        return x;
    }
    
    public String addBinary(String a, String b) {
        int[] x = toIntArray(a);
        int[] y = toIntArray(b);
        
        int[] z = new int[Math.max(x.length, y.length) + 1];
        
        int carry = 0;
        int i;
        for (i = 0; i < x.length || i < y.length; i++) {
            z[i] = carry;
            if (i < x.length) {
                z[i] += x[i];
            }
            if (i < y.length) {
                z[i] += y[i];
            }
            carry = z[i] / 2;
            z[i] %= 2;
        }
        if (carry > 0) {
            z[i] = carry;
            i++;
        }
        
        char[] c = new char[i];
        int m = i;
        while (i > 0) {
            i--;
            if (z[i] == 0) {
                c[m-1-i] = '0';
            } else {
                c[m-1-i] = '1';
            }
        }
        
        return String.valueOf(c);
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String res = s.addBinary("111", "1011");
        System.out.println(res);
    }
}
