/*
https://leetcode.com/problems/insert-interval/description/

57. Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/

import java.util.*;

// Definition for an interval.
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


////////////////////////////////////////////////////////////


class Solution {

    // search for the insert position of target. nums without duplications.
    private int bsearchPosition(int[] nums, int target) {
        if (nums.length <= 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] < target) {
            return left + 1;
        }
        return left;
    }

    private void intervalToArrays(List<Interval> intervals, int[] starts, int[] ends) {
        for (int i = 0; i < intervals.size(); i ++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
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

        // to arrays
        int size = intervals.size();
        int[] starts = new int[size];
        int[] ends = new int[size];

        intervalToArrays(intervals, starts, ends);

        // binary search
        int startPos = bsearchPosition(starts, newInterval.start);
        int endPos = bsearchPosition(ends, newInterval.end)-1;

        // check if included
        if (startPos > 0) {
            if (intervals.get(startPos - 1).end >= newInterval.start) {
                startPos = startPos - 1;
            }
        }
        if (endPos < size - 1) {
            if (intervals.get(endPos + 1).start <= newInterval.end) {
                endPos = endPos + 1;
            }
        }

        // merge
        if (startPos > endPos) { // no overlap
            intervals.add(startPos, newInterval);
            return intervals;
        }

        // merge startPos ~ endPos with newInterval
        newInterval.start = Math.min(newInterval.start, intervals.get(startPos).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(endPos).end);

        // slice
        List<Interval> res = new ArrayList<>();
        if (startPos > 0) {
            res.addAll(intervals.subList(0, startPos));
        }
        res.add(newInterval);

        if (endPos < size - 1) {
            List<Interval> remain = intervals.subList(endPos+1, size);
            res.addAll(remain);
        }
        return res;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));

        List<Interval> res = s.insert(intervals, new Interval(4, 9));
        for (Interval i : res) {
            System.out.println(i.start + " " + i.end);
        }
    }
}
