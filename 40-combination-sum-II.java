/*
https://leetcode.com/problems/combination-sum-ii/description/

40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

import java.util.*;

class Solution {

    String encodingCombination(List<Integer> list) {
        Collections.sort(list);
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s += list.get(i) + ",";
        }
        return s;
    }

    void addCombination(HashMap<String, List<Integer>> map, List<Integer> comb) {
        String key = encodingCombination(comb);
        map.put(key, comb);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<HashMap<String, List<Integer>>> dp = new ArrayList<HashMap<String, List<Integer>>>();
        for (int i = 0; i <= target; i++) {
            dp.add(null);
        }
        dp.set(0, new HashMap<String, List<Integer>>());
        addCombination(dp.get(0), new ArrayList<Integer>());

        for (int c = 0; c < candidates.length; c++) {
            int val = candidates[c];
            for (int i = target; i >= 0; i--) {
                if (dp.get(i) == null) {
                    continue;
                }
                int j = i + val;
                if (j > target) {
                    continue;
                }

                HashMap<String, List<Integer>> combs = dp.get(j);
                if (combs == null) {
                    combs = new HashMap<String, List<Integer>>();
                    dp.set(j, combs);
                }

                HashMap<String, List<Integer>> from = dp.get(i);

                for (List<Integer> fromComb: from.values()) {
                    List<Integer> newComb = new ArrayList<Integer>(fromComb);
                    newComb.add(val);

                    addCombination(combs, newComb);
                }
            }
        }

        HashMap<String, List<Integer>> resultMap = dp.get(target);
        if (resultMap == null) {
            return new ArrayList<List<Integer>>();
        }

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> comb: resultMap.values()) {
            result.add(comb);
        }
        return result;
    }
}