

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int p = 0, q = n-1;
        
        while (p < q) {
            int sum = numbers[p] + numbers[q];
            if (sum == target) {
                return new int[]{p+1, q+1};
            }
            
            if (sum < target) {
                p++;
            } else {
                q--;
            }
        }
        return null;
    }
}

