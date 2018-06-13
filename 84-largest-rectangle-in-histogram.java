/*
https://leetcode.com/problems/largest-rectangle-in-histogram/description/

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10
*/

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] hs) {
        if (hs.length == 0) {
            return 0;
        }

        // create a new array
        int[] heights = new int[hs.length + 2];
        for (int i = 0; i < hs.length; i++) {
            heights[i+1] = hs[i];
        }
        heights[0] = 0;
        heights[hs.length+1] = 0;

        Stack<Integer> s = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            // try to push in h
            int h = 0;
            if (i < heights.length) {
                h = heights[i];
            }
            // System.out.printf("current %d: %d\n", i, h);
            
            // pop out all elements that larger than h
            while(!s.empty() && heights[s.peek()] > h) {
                // calc the area based on the poped out height
                int p = s.pop();
                int baseHeight = heights[p];

                int right = i - 1;  // the right most position
                int left = p;
                if (!s.empty()) {
                    left = s.peek() + 1;
                }

                int area = (right - left + 1) * baseHeight;
                if (max < area) {
                    max = area;
                }

                // System.out.printf("  pop %d(%d), [%d - %d], area=%d, max=%d\n", p, baseHeight, left, right, area, max);
            }

            // push in current position
            s.push(i);
        }

        return max;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int[] heights = new int[]{2,1,2};
        int area = s.largestRectangleArea(heights);
        System.out.println(area);
    }
}