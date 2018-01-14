/*
https://leetcode.com/problems/multiply-strings/description/

43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
    public String multiply(String num1, String num2) {
        int[] a = new int[num1.length()];
        int[] b = new int[num2.length()];
        int[] c = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            a[i] = num1.charAt(num1.length() - i - 1) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            b[i] = num2.charAt(num2.length() - i - 1) - '0';
        }

        for (int i = 0; i < a.length; i++) {
            // multiply a[i] with b
            int forward = 0;
            for (int j = 0; j < b.length; j++) {
                c[i+j] += a[i] * b[j] + forward;
                forward = c[i+j] / 10;
                c[i+j] %= 10;
            }
            if (forward > 0) {
                c[i+b.length] = forward;
            }
        }

        // output
        int len = c.length;
        while (len > 0 && c[len-1] == 0) {
            len -= 1;
        }
        if (len == 0) {
            return "0";
        }
        
        String s = "";
        for (int i = len-1; i >= 0; i--) {
            s += c[i];
        }
        return s;
    }
}


class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.multiply("334", "10");
        System.out.println(result);
    }
}