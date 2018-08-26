

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k-1) continue;
            if (i >= k) sum -= nums[i-k];
            if (max < sum) max = sum;
        }
        return max / (double)k;
    }
}