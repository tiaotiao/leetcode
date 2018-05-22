
// O(n)

class Solution {
    
    public int minSubArrayLen(int s, int[] nums) {
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
