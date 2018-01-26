class Solution {
    
    private void choose(int n, int[] nums, int[] count, int[] choice, int index, List<List<Integer>> res) {
        // int n = nums.length;
        if (index >= n) {
            // add a result
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < choice[i]; k++) {
                    r.add(nums[i]);
                }
            }
            res.add(r);
            return;
        }
        
        for (int c = 0; c <= count[index]; c++) {
            choice[index] = c;
            choose(n, nums, count, choice, index+1, res);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n <= 0) {
            return res;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int c = 0;
            if (map.containsKey(num)) {
                c = map.get(num);    
            }
            map.put(num, c+1);
        }
        
        int m = map.size();
        int[] unique = new int[m];
        int[] count = new int[m];
        int i = 0;
        for (int num : map.keySet()) {
            int c = map.get(num);
            unique[i] = num;
            count[i] = c;
            i++;
        }
        
        int[] choice = new int[m];
        
        choose(m, unique, count, choice, 0, res);
        
        return res;
    }
}