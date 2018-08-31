

class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isValid(i)) count += 1;
        }
        return count;
    }

    private boolean isValid(int n) {
        boolean ok = false;
        while (n > 0) {
            int d = n % 10;
            n /= 10;

            if (d == 0 || d == 1 || d == 8) {
                continue;
            }
            if (d == 2 || d == 5 || d == 6 || d == 9) {
                ok = true;
            } else {    // 3, 4, 7
                return false;
            }
        }
        return ok;
    }
}