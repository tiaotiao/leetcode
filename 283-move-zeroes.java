

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n <= 0) return;

        int insertIdx = 0;
        int scanIdx = 0;

        while (insertIdx < n && scanIdx < n) {
            int num = nums[scanIdx];
            if (num == 0) {
                scanIdx += 1;
                continue;
            }

            nums[scanIdx] = 0;
            nums[insertIdx] = num;

            scanIdx += 1;
            insertIdx += 1;
        }
    }
}