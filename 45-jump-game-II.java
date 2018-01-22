
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int current = 0, next = -1;
        int i = 0;
        
        if (n <= 1) {
            return 0;
        }
        
        while (i < n) {
            if (i > current) {
                steps += 1;
                current = next;
                next = -1;
            }
            if (nums[i] + i > next) {
                next = nums[i] + i;
                if (next >= n-1) {
                    return steps + 1;
                }
            }
            i++;
        }
        return -1;
    }
}