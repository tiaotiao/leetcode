/*
https://leetcode.com/problems/combination-sum/description/

39. Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

import java.util.*;

/*
DP  O(n*T)
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            dp.add(null);
        }
        dp.set(0, new ArrayList<List<Integer>>());
        dp.get(0).add(new ArrayList<Integer>());

        for (int i = 0; i < candidates.length; i++) {
            int c = candidates[i];

            for (int j = 0; j < target; j++) {
                int k = j + c;
                if (k > target) {
                    break;
                }
                if (dp.get(j) != null) {
                    List<List<Integer>> combs = dp.get(k);
                    if (combs == null) {
                        combs = new ArrayList<List<Integer>>();
                        dp.set(k, combs);
                    }
                    // copy combinations
                    for (int t = 0; t < dp.get(j).size(); t++) {
                        List<Integer> comb = new ArrayList<Integer>(dp.get(j).get(t));
                        comb.add(c);
                        dp.get(k).add(comb);
                    }
                }
            }
        }

        // check target
        if (dp.get(target) == null) {
            return new ArrayList<List<Integer>>();
        }
        return dp.get(target);
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> result = s.combinationSum(candidates, target);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> comb = result.get(i);
            for (int j = 0; j < comb.size(); j++) {
                System.out.print(comb.get(j) + " ");
            }
            System.out.println();
        }
    }
}