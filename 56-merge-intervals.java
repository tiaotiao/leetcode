/*
https://leetcode.com/problems/merge-intervals/description/

56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

import java.util.*;

// Definition for an interval.
public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

/////////////////////////////////////////////////////////

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        // sort intervals
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        });

        // merge
        int size = 0;
        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval in = intervals.get(i);
            if (current.end < in.start) {
                intervals.set(size, current);
                current = in;
                size += 1;
                continue;
            }

            if (current.end < in.end) {
                current.end = in.end;
            }
        }
        intervals.set(size, current);
        size += 1;

        return intervals.subList(0, size);
    }
}