
class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 0) return 0;
        
        int max = nums[0];
        List<Integer> tops = new ArrayList<>();
        for (int v: nums) {
            insert(tops, v);
            max = Math.max(max, v);
        }
        
        if (tops.size() < 3) return max;
        
        int min = tops.get(0);
        for (int v: tops) {
            min = Math.min(min, v);
        }
        return min;
    }
    
    private void insert(List<Integer> tops, int v) {
        for (int val: tops) 
            if (v == val) return;
        
        for (int i = 0; i < tops.size(); i++) {
            int val = tops.get(i);
            if (v > val) {
                tops.set(i, v);
                v = val;
            }
        }
        if (tops.size() < 3) tops.add(v);
    }
}
