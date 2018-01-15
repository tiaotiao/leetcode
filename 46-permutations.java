/*
https://leetcode.com/problems/permutations/description/

46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

import java.util.*;

class Solution {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private List<Integer> toArray(int[] nums) {
        List<Integer> p = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            p.add(nums[i]);
        }
        return p;
    }

    /*
    https://en.wikipedia.org/wiki/Heap%27s_algorithm
    Fastest
    */
    public void heapsAlgorithm(int[] nums, int n,  List<List<Integer>> results) {
        if (n <= 1) {
            // output result
            results.add(toArray(nums));
            return;
        }

        for (int i = 0; i < n-1; i++) {
            heapsAlgorithm(nums, n-1, results);

            if (n % 2 == 0) {
                swap(nums, i, n-1);
            } else {
                swap(nums, 0, n-1);
            }
        }
        heapsAlgorithm(nums, n-1, results);
    }

    /*
    Need much space, easy to understand
    */
    public List<List<Integer>> insertGenerate(int[] nums, int n) {
        List<List<Integer>> result = new ArrayList<>();;
        
        if (n <= 1) {
            // result = new ArrayList<>();
            List<Integer> p = new ArrayList<Integer>();
            p.add(nums[0]);
            result.add(p);
            return result;
        }

        List<List<Integer>> perms = insertGenerate(nums, n-1);

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < perms.size(); j++) {
                List<Integer> newPerm = new ArrayList<>(perms.get(j));
                newPerm.add(i, nums[n-1]);
                result.add(newPerm);
            }
        }
        return result;
    }

    /*
    Fast, not in order
    */
    public void swapGenerate(int[] nums, int index, List<List<Integer>> results) {
        if (index >= nums.length) {
            results.add(toArray(nums));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            swapGenerate(nums, index+1, results);
            swap(nums, i, index);
        }
    }

    /*
    Slow, in order, easy to understand, use mark to improve performance
    */
    public void easyGenerate(int[] nums, int index, int[] temp, List<List<Integer>> results) {
        if (index >= nums.length) {
            results.add(toArray(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (temp[j] == nums[i]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[index] = nums[i];
                easyGenerate(nums, index+1, temp, results);
            }
        }
    }

    //////////////////////////////////////////////

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        // heapsAlgorithm(nums, nums.length, results);
        // results = insertGenerate(nums, nums.length);
        // swapGenerate(nums, 0, results);
        easyGenerate(nums, 0, new int[nums.length], results);

        return results;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int n = 4;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        } 
        
        List<List<Integer>> results = s.permute(nums);

        for (int i = 0; i < results.size(); i++) {
            List<Integer> p = results.get(i);
            for (int j = 0; j < p.size(); j++) {
                System.out.print(p.get(j) + " ");
            }
            System.out.println();
        }
    } 
}