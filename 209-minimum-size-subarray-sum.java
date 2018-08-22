


class Solution {
    
    public int minSubArrayLen(int s, int[] nums) {
        return minSubArrayLen_besarch_len(s, nums);
    }

    // O(n) binary search
    public int minSubArrayLen_besarch_len(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int sum = 0;
        for (int num: nums) sum += num;
        if (sum < s) return 0;

        int min = 1, max = n;
        
        while (min < max) {
            int len = (min + max) / 2;

            // calc sums for window with size=len
            boolean ok = false;
            sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if (i < len) {
                    if (sum >= s) {
                        ok = true;
                        break;
                    }
                    continue;
                }

                sum -= nums[i - len];
                if (sum >= s) {
                    ok = true;
                    break;
                }
            }

            // bsearch
            if (ok) {   // go smaller
                max = len;
            } else {
                min = len + 1;
            }
        }

        return min;
    }

    // O(n) two pointers
    public int minSubArrayLen_two_pointers(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int sum = 0, minlen = 0;
        int left=0, right=0;
        while (right < n) {
            sum += nums[right++];

            while (sum >= s && left < right) {
                if (minlen == 0 || minlen > right - left) {
                    minlen = right - left;
                }
                sum -= nums[left++];
            }
        }

        return minlen;
    }

    // O(n) prefix sum
    public int minSubArrayLen_prefixsum(int s, int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        
        int sums[] = new int[n];
        for (int i = 0; i < n; i++) {
            sums[i] = nums[i];
            if (i > 0) sums[i] += sums[i-1];
        }
        
        if (sums[n-1] < s) {
            return 0;
        }
        
        int left = 0, right = 0;    // current sum from [left to right]
        int minimal = n;

        while (left < n && right < n) {
            int sum = sums[right];
            if (left > 0) {
                sum -= sums[left-1];
            }
            
            if (sum >= s) {
                if (right - left + 1 < minimal) {
                    minimal = right - left + 1;
                }
                left += 1;
            } else {
                right += 1;
            }
        }
        
        return minimal;
    }
}
