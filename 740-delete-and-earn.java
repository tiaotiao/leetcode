class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        Arrays.sort(nums);
        
        int[] a = new int[n];
        int[] b = new int[n];
        
        int m = 0;
        int curr = nums[0], count = 1;
        
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num != curr) {
                a[m] = curr;
                b[m] = count;
                
                curr = num;
                count = 0;
                m += 1;
            }
            count += 1;
        }
        
        a[m] = curr;
        b[m] = count;
        m += 1;

        // solve
        int[] p = new int[4];
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            // int num = a[i];
            // int count = b[i];
            curr = a[i] * b[i];
            for (int k = 1; k <= 3; k++) {
                int j = i - k;
                if (j < 0) break;
                if (j == i-1 && a[i]-1 == a[i-1]) continue;

                curr = Math.max(curr, a[i] * b[i] + p[k]);
            }
            
            max = Math.max(max, curr);
            
            p[3] = p[2]; p[2] = p[1]; p[1] = curr;
        }
        
        return max;
    }
}