/*
https://leetcode.com/problems/pascals-triangle/description/

118. Pascal's Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tran = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int val = 1;
                if (j != 0 && j != i) {
                    val = tran.get(i-1).get(j-1) + tran.get(i-1).get(j);
                }
                row.add(val);
            }
            tran.add(row);
        }

        return tran;
    }
}