/*
https://leetcode.com/problems/divide-two-integers/description/

Given two integers dividend and divisor, divide two integers without 
using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3

Example 2:
Input: dividend = 7, divisor = -3
Output: -2

Note:
Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within 
the 32-bit signed integer range: [23^1,  2^31-1]. For the purpose of this problem, 
assume that your function returns 2^31-1 when the division result overflows.
*/


class Solution {
    public int divide(int dividend_int, int divisor_int) {
        long dividend = (long)dividend_int;
        long divisor = (long)divisor_int;

        // corner cases
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        // remove signs
        int sign = 1;
        if (dividend > 0 != divisor > 0) {
            sign = -1;
        }
        dividend = Math.abs((long)dividend);
        divisor = Math.abs((long)divisor);
        System.out.println("sign " + sign);

        // corner cases
        if (dividend < divisor) {
            return 0;
        }
        if (dividend == divisor) {
            return sign;
        }

        // calculate multi[p] = divisor * 2^p
        long[] multi = new long[32];
        long[] x = new long[32];
        multi[0] = divisor;
        x[0] = 1;
        int p;
        for (p = 1; p < 32; p++) {
            multi[p] = multi[p-1] + multi[p-1];
            x[p] = x[p-1] + x[p-1];
            if (multi[p] > dividend) {
                break;
            }
        }
        System.out.println("p " + p);

        // calc reslut
        long quot = 0;
        long total = 0;
        for (int i = p-1; i >= 0; i--) {
            if (total + multi[i] > dividend) {
                continue;
            }
            total += multi[i];
            quot += x[i];
        }
        System.out.println("quot " +quot);

        // overflow
        long max = Integer.MAX_VALUE;
        if (sign < 0) {
            max += 1;
        }
        if (quot > max) {
            return Integer.MAX_VALUE;
        }

        // reslut
        if (sign < 0) {
            return (int)(-quot);
        }
        return (int)quot;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.divide(-2147483648, -1);
        System.out.println(r);
    }
}