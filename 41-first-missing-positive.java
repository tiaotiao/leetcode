/*
https://leetcode.com/problems/first-missing-positive/description/

41. First Missing Positive

Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/


/*
O(n)
Go through the list, for each number, skip it if it is non-positive or out of range.
Otherwise, switch it to the correct position.
In the end, go through the list to see who is not in the correct position.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int val = nums[i];
            if (val <= 0 || n < val) {
                i++;
                continue;
            }
            if (val != i+1) {
                nums[i] = nums[val-1];
                nums[val-1] = val;
                if (val == nums[i]) {
                    i++;
                    continue;
                }
                val = nums[i];
                continue;
            }
            i++;
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }
}