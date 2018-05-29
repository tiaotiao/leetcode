/*
https://leetcode.com/problems/ugly-number-ii/description/

264. Ugly Number II

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/

import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> h = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        addNum(1, 1, h, set);

        for (int i = 0; i < n-1; i++) {
            int num = h.poll();
            addNum(num, 2, h, set);
            addNum(num, 3, h, set);
            addNum(num, 5, h, set);
        }

        return h.poll();
    }

    private void addNum(int num, int multiple, PriorityQueue<Integer> h, HashSet<Integer> set) {
        if (num * multiple / multiple != num) { // overflow
            return;
        }
        num = num * multiple;
        if (set.contains(num)) {    // duplicate
            return;
        }
        h.add(num);
        set.add(num);
    }
}