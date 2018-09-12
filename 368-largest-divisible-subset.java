
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        int n = nums.length;
        if (n == 0) return res;
        
        // sort
        Arrays.sort(nums);
        
        // init
        int[] dp = new int[n];
        int[] prev = new int[n];
        int max = 0;
        int maxi = -1;
        
        // dp
        for (int i = 0; i < n; i++) {
            int k = -1;
            int len = 0;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] % nums[j] != 0) 
                    continue;
                if (dp[j] > len) {
                    len = dp[j];
                    k = j;
                }
            }
            
            dp[i] = len + 1;
            prev[i] = k;
            
            if (dp[i] > max) {
                max = dp[i];
                maxi = i;
            }
        }
        
        // get result
        while (maxi >= 0) {
            res.add(nums[maxi]);
            maxi = prev[maxi];
        }
        
        return res;
    }
}