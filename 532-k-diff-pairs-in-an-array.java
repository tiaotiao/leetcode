
import java.util.*;


class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;

        if (k == 0) {
            int j = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[j]) {
                    if (i == j+1) {
                        count += 1;
                    }
                } else {
                    j = i;
                }
            }
        } else {
            int j = 0, i = 1;
            while (i < nums.length && j < nums.length) {
                if (i>0 && nums[i] == nums[i-1]) {
                    i++;
                    continue;
                }
                if (j>0 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                if (i == j) {
                    i += 1;
                    continue;
                }

                int diff = nums[i] - nums[j];
                if (diff == k) {
                    count += 1;
                }

                if (diff >= k) {
                    j += 1;
                    continue;
                } else {
                    i += 1;
                }
            }
        }

        return count;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        // int[] nums = new int[]{3, 1, 4, 1, 5};
        // int k = 2;
        int[] nums = new int[]{1, 1, 2, 2, 3, 4, 5};
        int k = 2;

        int count = s.findPairs(nums, k);

        System.out.println(count);
    }
}