

class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int MAXN = 50000;
        int[] left = new int[MAXN];
        int[] right = new int[MAXN];
        int[] count = new int[MAXN];
        int degree = 0;
        
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            
            if (count[x] == 0) {
                left[x] = i;
                right[x] = i;
            } else {
                if (i < left[x]) left[x] = i;
                if (right[x] < i) right[x] = i;
            }
            
            count[x] += 1;
            if (count[x] > degree) degree = count[x];
        }
        
        int min = n;
        for (int x = 0; x < MAXN; x++) {
            if (count[x] == 0) continue;
            if (count[x] != degree) continue;
            
            int length = right[x] - left[x] + 1;
            if (min > length) {
                min = length;
            }
        }
        
        return min;
    }
}
