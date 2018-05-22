/*
https://leetcode.com/problems/triangle/description/

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        List<Integer> prev, curr, temp;
        prev = new ArrayList<>();
        curr = new ArrayList<>();
        
        for (List<Integer> row: triangle) {
            temp = prev;
            prev = curr;
            curr = temp;
            curr.clear();
            
            for (int i = 0; i < row.size(); i++) {
                int val = row.get(i);
                int prevLeft = Integer.MAX_VALUE, prevRight = Integer.MAX_VALUE;
                
                if (row.size() == 1) {
                    curr.add(val);
                    continue;
                }

                if (i == 0) {
                    val += prev.get(i);
                } else if (i == row.size()-1) {
                    val += prev.get(i-1);
                } else {
                    prevLeft = prev.get(i-1);
                    prevRight = prev.get(i);
                    val += Math.min(prevLeft, prevRight);
                }
                
                curr.add(val);
            }
        }
        
        int minimum = Integer.MAX_VALUE;
        for (int val: curr) {
            minimum = Math.min(minimum, val);
        }
        
        return minimum;
    }
}