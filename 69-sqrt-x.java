/*
https://leetcode.com/problems/sqrtx/description/

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
*/

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long min = 1;
        long max = (long)1 << 31;
        
        while (min <= max) {
            long mid = (min + max) / 2;
            long num = mid * mid;
            // System.out.printf("(%d - %d) %d: %d\n", min, max, mid, num);
            if (num == x) {
                return (int)mid;
            } else if (num < x) {
                min = mid + 1;
            } else {    // num > target
                max = mid - 1;
            }
        }

        return (int) (min-1);
    }
}
