

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return solution_n(s);
    }

    private boolean solution_n(String s) {
        int n = s.length();
        if (n <= 1) return false;

        String t = s + s;
        return t.substring(1, n+n-1).contains(s);
    }

    private boolean solution_n2(String s) {
        int n = s.length();
        if (n <= 1) return false;

        for (int k = 2; k <= n; k++) {
            if (n % k != 0) continue;
            int m = n / k;
            String sub = s.substring(0, m);
            StringBuilder sb = new StringBuilder(n + 1);
            for (int i = 0; i < k; i++) {
                sb.append(sub);
            } 
            if (sb.toString().equals(s)) return true;
        }

        return false;
    }
}