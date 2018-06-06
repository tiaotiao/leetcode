
import java.util.*;

import com.sun.javafx.collections.SortableList;

/*
O(nlogn)
Sort array first. Use two pointer go from front and back. 
If the sum of two pointer larger than target, let the back one move one position left.
If the sum of them smaller than target, let the front one move one position right.
*/
class Solution {

    class Item implements Comparable<Item> {
        int num;
        int idx;

        Item(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Item b) {
            return this.num - b.num;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < nums.length; i++) {
            items.add(new Item(nums[i], i));
        }

        Collections.sort(items);

        int i = 0, j = items.size()-1;
        while (i < j) {
            int sum = items.get(i).num + items.get(j).num;
            if (sum == target) {
                return new int[]{items.get(i).idx, items.get(j).idx};
            }
            else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}

// O(n^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

// O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                int j = map.get(num);
                return new int[]{j, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}


/////////////////////////////
// test

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        
        int[] result = s.twoSum(nums, target);
        System.out.printf("%d, %d\n", result[0], result[1]);
    }
}