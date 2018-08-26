

class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        if (n == 0) return "";

        char[] cs = s.toCharArray();
        
        for (int i = 0, j = k; i < n; i += 2*k, j += 2*k) {
            int start = i;
            int end = j;
            if (end > n) end = n;

            int size = end - start;
            // System.out.println("reversing " + start + " " + end);
            for (int idx = 0; idx < size / 2; idx++) {
                // System.out.println("  " + (start + idx) + " " + (end - idx - 1));
                char tmp = cs[start + idx];
                cs[start + idx] = cs[end - idx - 1];
                cs[end - idx - 1] = tmp;
            }
        }

        return new String(cs);
    }
}