/*
https://leetcode.com/problems/pascals-triangle-ii/description/

119. Pascal's Triangle II

Given a non-negative index k where k <= 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]

Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*/

import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        List<Integer> prev = new ArrayList<>(rowIndex + 1), tmp;

        for (int i = 0; i <= rowIndex; i++) {
            tmp = row;
            row = prev;
            prev = tmp;
            row.clear();
            for (int j = 0; j <= i; j++) {
                int val = 1;
                if (j != 0 && j != i) {
                    val = prev.get(j-1) + prev.get(j);
                }
                row.add(val);
            }
        }

        return row;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
    
        List<Integer> l = s.getRow(20);
        System.out.println(l);
    }
}