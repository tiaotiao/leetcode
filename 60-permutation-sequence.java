class Solution {
    public String getPermutation(int n, int k) {
        // calc f[]
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = i * f[i-1];
        }
        
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }
        
        int[] res = new int[n];
        k -= 1;
        
        // permutation
        for (int m = n-1; m >= 0; m--) {
            int r = k/f[m];
            k %= f[m];
            
            res[n-1-m] = nums.get(r);
            nums.remove(r);
        }
        
        String s = "";
        for (int i = 0; i < n; i++) {
            s += res[i];
        }
        return s;
    }
}