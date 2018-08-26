

class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return true;

        return valid(s, 0, n-1, true);
    }

    private boolean valid(String s, int i,  int j, boolean del) {
        for (; i < j; i++, j--) {
            char a = s.charAt(i);
            char b = s.charAt(j);

            if (a == b) continue;
            if (!del) return false;
            del = false;
            boolean ok;
            if (a == s.charAt(j-1)) {
                ok = valid(s, i, j-1, false);
                if (ok) return true;
            }
            if (b == s.charAt(i+1)){
                ok = valid(s, i+1, j, false);
                if (ok) return true;
            } 
            return false;
        }
        return true;
    }
}