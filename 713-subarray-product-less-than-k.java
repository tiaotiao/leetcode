
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int total = 0, product = 1;
        for (int i = 0, j = 0; i < n; i++) {
            product *= nums[i];
            while(product >= k && j <= i) {
                product /= nums[j];
                j += 1;
            }
            total += i - j + 1;
        }
        
        return total;
    }
}