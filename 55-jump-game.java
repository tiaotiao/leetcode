
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int far = 0;
        int i = 0;
        while (i <= far) {
            if (nums[i] + i > far) {
                far = nums[i] + i;
            }
            i++;
            if (far >= n-1) {
                return true;
            }
        }
        return false;
    }
}