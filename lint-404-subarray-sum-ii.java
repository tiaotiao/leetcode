
class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int subarraySumII(int[] nums, int start, int end) {
        // O(n)
        int n = nums.length;
        if (n == 0) return 0;

        int total = (n * (n+1)) / 2;
        int less = lessThanK(nums, start);
        int larger = largerThanK(nums, end);

        return total - less - larger;
    }
    
    private int lessThanK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            
            while(k <= sum && i<=j) {
                sum -= nums[i++];
            }
            
            count += j - i + 1;
        }
        return count;
    }
    
    private int largerThanK(int[] nums, int k) {
        int sum = 0, count = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while(j < nums.length && sum <= k) {
                sum += nums[j++];
            }
            
            if (k < sum) count += nums.length - j + 1;
            sum -= nums[i];
        }
        return count;
    }
}



class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {3,2,5,1,2,4,3,1};
        int start = 4, end = 8;

        System.out.println(s.subarraySumII(nums, start, end));
    }
}