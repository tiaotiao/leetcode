/*
https://leetcode.com/problems/powx-n/description/

50. Pow(x, n)

Implement pow(x, n).


Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
*/

/*
O(logn)
n could be negtive, 
*/
class Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // boolean negtive = false;
        // if (n < 0) {
        //     negtive = true;
        //     n = -n;
        // }

        double[] pow2 = new double[33];

        pow2[0] = x;
        int m = n;
        for (int i = 1; i < 33; i++) {
            pow2[i] = pow2[i-1] * pow2[i-1];
            m = m / 2;
            if (m == 0) {
                break;
            }
        }

        double result = 1;
        int i = 0;
        m = n;
        while (m != 0) {
            if (m % 2 != 0) {
                result *= pow2[i];
            }
            m /= 2;
            i++;
        }

        if (n < 0) {
            return 1/result;
        }

        return result;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        double r = s.myPow(2.0, -2147483647);
        System.out.print(r);
    }
}
