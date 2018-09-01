
class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int[] f = new int[10];
        f[0] = 0;
        f[1] = 1;
        int p2 = 10;
        for (int i = 2; i < 10; i++) {
            f[i] = 10*f[i-1] + p2;
            p2 = p2*10;
        }

        int result = 0;
        int i = 0;
        int p = 1, prev = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;

            if (d != 0) {
                result += d * f[i] + 1;
                if (d == 1) result += prev;
                else result += p;
            }

            prev += p * d;

            p *= 10;
            i += 1;
        }

        return result;
    }
}