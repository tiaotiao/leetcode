
import java.util.*;

class Solution {
    
    private void choose(int[] nums, int[] choice, int index, List<List<Integer>> res) {
        int n = nums.length;
        if (index >= n) {
            // add a result
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (choice[i] == 1) {
                    r.add(nums[i]);
                }
            }
            res.add(r);
            return;
        }
        
        for (int c = 0; c <= 1; c++) {
            choice[index] = c;
            choose(nums, choice, index+1, res);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        if (n == 0) {
            return res;
        }
        
        int[] choice = new int[n];
        
        choose(nums, choice, 0, res);
        
        return res;
    }
}