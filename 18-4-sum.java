/*
https://leetcode.com/problems/4sum/description/

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

import java.util.*;

class Solution {
    
    class Pair {
        public int a;
        public int b;
        
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private ArrayList<Integer> getQuad(Pair p, Pair q, int[] nums) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(nums[p.a]);
        a.add(nums[p.b]);
        a.add(nums[q.a]);
        a.add(nums[q.b]);
        
        Collections.sort(a);
        return a;
    }
    
    
    /////////////////////////////////////////
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Pair>> twoSums = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int s = nums[i] + nums[j];
                Pair pair = new Pair(i, j);
                
                ArrayList<Pair> a;
            
                if (!twoSums.containsKey(s)) {
                    a = new ArrayList<Pair>();
                    twoSums.put(s, a);
                } else {
                    a = twoSums.get(s);
                }
                a.add(pair);
            }
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        HashMap<String, Boolean> mapping = new HashMap<String, Boolean>();
        for (int s: twoSums.keySet()) {
            ArrayList<Pair> a = twoSums.get(s);
            if (!twoSums.containsKey(target-s)) {
                continue;
            }
            ArrayList<Pair> b = twoSums.get(target-s);
            
            // combine a b
            for (Pair p: a) {
                for (Pair q: b) {
                    if (p.a == q.a || p.a == q.b || p.b == q.a || p.b == q.b) {
                        continue;
                    }
                    
                    ArrayList<Integer> quad = getQuad(p, q, nums);
                    String quadStr = quad.toString();
                    
                    // check duplicated
                    if (mapping.containsKey(quadStr)) {
                        continue;
                    }
                    
                    mapping.put(quadStr, true);
                    
                    // append a result
                    results.add(quad);
                }
            }
        }
        
        return results;
    }
}

///////////////////////////////////////////////////////////////

class Main {
    
    static class testCase {
        int[] s;
        int target;
        List<List<Integer>> expect;
        
        public testCase(int[] s, int target, int[][] expect) {
            this.s = s;
            this.target = target;
            this.expect = new ArrayList<List<Integer>>();
            for (int[] row: expect) {
                List<Integer> r = new ArrayList<Integer>();
                for (int i: row) {
                    r.add(i);
                }
                this.expect.add(r);
            }
        }
        
        public boolean check(List<List<Integer>> results) {
            if (expect.size() != results.size()) {
                return false;
            }
            for (int i = 0; i < expect.size(); i++) {
                List<Integer> exp = expect.get(i);
                List<Integer> res = results.get(i);
                
                Collections.sort(exp);
                Collections.sort(res);
                
                if (!exp.equals(res)) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        ArrayList<testCase> cases = new ArrayList<testCase>();
        cases.add(new testCase(new int[] {1, 0, -1, 0, -2, 2}, 0, new int[][] {{-1, 0, 0, 1},{-2, -1, 1, 2},{-2, 0, 0, 2}}));
        cases.add(new testCase(new int[] {0, 0, 0, 0}, 0, new int[][]{{0, 0, 0, 0}}));

        Solution solution = new Solution();
        
        boolean ok = true;
        for (testCase c: cases) {
            List<List<Integer>> results = solution.fourSum(c.s, c.target);
            
            if (!c.check(results)) {
                System.out.printf("test failed: s=%s, target=%d, expect=%s, results=%s\n", 
                    Arrays.toString(c.s), c.target, c.expect.toString(), results.toString());
                ok = false;
            }
        }
        
        if (ok) {
            System.out.println("ok");
        }
    }
}

