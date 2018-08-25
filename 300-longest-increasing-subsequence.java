
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return nums.length;
        int[] inc = new int[n]; // current increasing sub seq
        int m = 1;  // current longest length

        inc[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int x = nums[i];
            // binary search for inc
            int pos = Arrays.binarySearch(inc, 0, m, x);
            if (pos < 0) pos = -pos - 1;
            if (pos >= m) {
                inc[m++] = x;
            } else {
                inc[pos] = x;
            }
        }

        return m;
    }
}
