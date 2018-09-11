

class NumArray {
    int[] sum;
    int[] nums;
    int n;
    
    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums; 
        this.sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            updateValue(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        updateValue(i, delta);
    }
    
    private void updateValue(int i, int delta) {
        int j = i + 1;
        while(j <= n) {
            sum[j] += delta;
            j += lowbit(j);
        }
    }
    
    public int sumRange(int i, int j) {
        int s = sumPrefix(j);
        int t = sumPrefix(i-1);
        
        return s - t;
    }
    
    private int sumPrefix(int i) {
        int s = 0;
        int j = i + 1;
        while(j > 0) {
            s += sum[j];
            j -= lowbit(j);
        }
        return s;
    }
    
    private int lowbit(int x) {
        return x & (-x);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */