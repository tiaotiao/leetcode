/*
https://leetcode.com/problems/permutations-ii/description/

47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

import java.util.*;

class Solution {

    class Item {
        int val;
        int count;
        Item(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public List<List<Integer>> insertGenerate(int[] nums) {
        List<Item> items = new ArrayList<>(nums.length);
        
        Arrays.sort(nums);

        int val = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                val = nums[i];
                count += 1;
                continue;
            }

            if (nums[i] == val) {
                count += 1;
                continue;
            }

            items.add(new Item(val, count));

            val = nums[i];
            count = 1;
        }
        items.add(new Item(val, count));

        // generate
        return insertGenerateItems(items, items.size());
    }

    private List<List<Integer>> insertGenerateItems(List<Item> items, int n) {
        List<List<Integer>> results = new ArrayList<>();
        Item item = items.get(n-1);

        if (n <= 1) {
            insertItem(new ArrayList<Integer>(), 0, item.val, item.count, results);
            return results;
        }

        List<List<Integer>> shorterLists = insertGenerateItems(items, n-1);

        for (List<Integer> list: shorterLists) {
            insertItem(list, list.size(), item.val, item.count, results);
        }

        return results;
    }

    private void insertItem(List<Integer> list, int index, int val, int remain, List<List<Integer>> results) {
        List<Integer> newList = new ArrayList<>(list);

        if (index <= 0) {
            for (int i = 0; i < remain; i++) {        
                newList.add(index, val);
            }
            results.add(newList);
            return;
        }

        for (int k = remain; k >= 0; k--) {
            newList = new ArrayList<>(list);
            for (int i = 0; i < k; i++) {       
                newList.add(index, val);
            }
            insertItem(newList, index-1, val, remain-k, results);
        }
    }

    /*
    https://leetcode.com/problems/permutations-ii/discuss/18602/
    ???
    */
    public List<List<Integer>> _insertGenerate(int[] nums, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        if (n <= 1) {
            lists.add(Arrays.asList(nums[0]));
            return lists;
        }

        List<List<Integer>> shorterLists = _insertGenerate(nums, n-1);

        int val = nums[n-1];
        for (List<Integer> l : shorterLists) {
            for (int i = 0; i <= l.size(); i++) {
                List<Integer> newList = new ArrayList<Integer>(l);
                newList.add(i, val);
                lists.add(newList); 

                if (i < l.size() && l.get(i) == val) { // ????? why it works
                    break;
                }
                // if (i >= l.size() || l.get(i) != val) {
                //     List<Integer> newList = new ArrayList<Integer>(l);
                //     newList.add(i, val);
                //     lists.add(newList);
                // }
            }
        }

        return lists;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results;

        // results = insertGenerate(nums);
        results = _insertGenerate(nums, nums.length);

        return results;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int n = 4;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i/2+1;
        } 
        
        List<List<Integer>> results = s.permuteUnique(nums);

        for (int i = 0; i < results.size(); i++) {
            List<Integer> p = results.get(i);
            for (int j = 0; j < p.size(); j++) {
                System.out.print(p.get(j) + " ");
            }
            System.out.println();
        }
    } 
}