/*
https://leetcode.com/problems/trapping-rain-water/

42. Trapping Rain Water

Total Accepted: 82287
Total Submissions: 241154
Difficulty: Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

package leetcode

import "sort"

func trap(height []int) int {
	if len(height) == 0 {
		return 0
	}

	sortedHeight := newTrapSortable(height)
	sort.Sort(sort.Reverse(sortedHeight))

	volume := 0
	left, right := sortedHeight.index[0], sortedHeight.index[0]

	for i := 1; i < sortedHeight.Len(); i++ {
		h := sortedHeight.height[i]
		x := sortedHeight.index[i]

		if x < left {
			volume += (left - x - 1) * h
			left = x
		} else if right < x {
			volume += (x - right - 1) * h
			right = x
		} else {
			volume -= h
		}
	}

	return volume
}

type trapSortable struct {
	height []int
	index  []int
}

func newTrapSortable(height []int) *trapSortable {
	s := new(trapSortable)
	s.height = height
	s.index = make([]int, len(s.height))
	for i := 0; i < len(s.index); i++ {
		s.index[i] = i
	}
	return s
}

func (s *trapSortable) Len() int {
	return len(s.height)
}

func (s *trapSortable) Less(i, j int) bool {
	return s.height[i] < s.height[j]
}

func (s *trapSortable) Swap(i, j int) {
	s.height[i], s.height[j] = s.height[j], s.height[i]
	s.index[i], s.index[j] = s.index[j], s.index[i]
}
