
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        int n = Math.max(s1.length, s2.length);
        for (int i = 0; i < n; i++) {
            int d1 = 0, d2 = 0;
            if (i < s1.length) {
                try {
                    d1 = Integer.parseInt(s1[i]);
                } catch (Exception e) {
                    d1 = 0;
                }
            }
            if (i < s2.length) {
                try {
                    d2 = Integer.parseInt(s2[i]);
                } catch (Exception e) {
                    d2 = 0;
                }
            }
            if (d1 > d2) return 1;
            if (d1 < d2) return -1;
        }
        return 0;
    }
}