/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        combine(1, n, k, comb, res);

        return res;
    }
    
    public void combine(int index, int n, int k, List<Integer> comb, List<List<Integer>> res) {
        if (k <= 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        if (index > n) {
            return;
        }
        
        for (int i = index; i <= n; i++) {
            comb.add(i);
            combine(i+1, n, k-1, comb, res);
            comb.remove(comb.size()-1);
        }
    }
}
