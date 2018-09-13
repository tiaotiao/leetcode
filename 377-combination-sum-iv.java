
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return 0;
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int j = 0; j < target; j++) {
            if (dp[j] == 0) continue;
            
            for (int i = 0; i < n; i++) {
                int val = nums[i];
                int k = j + val;
                if (k > target) continue;
                
                dp[k] += dp[j];
            }
        }
        
        return dp[target];
    }
}