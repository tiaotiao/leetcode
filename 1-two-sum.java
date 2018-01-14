
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

