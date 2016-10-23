/*
https://leetcode.com/problems/container-with-most-water/

11. Container With Most Water

Total Accepted: 100425
Total Submissions: 280409
Difficulty: Medium
Contributors: Admin

Given n non-negative integers a1, a2, ..., an, where each represents 
a point at coordinate (i, ai). n vertical lines are drawn such that 
the two endpoints of line i is at (i, ai) and (i, 0). 

Find two lines, which together with x-axis forms a container, 
such that the container contains the most water.

Note: You may not slant the container.
*/

package leetcode 

import "sort"

func maxArea(height []int) int {
    if len(height) == 0 {
        return 0
    }
    
    a := newMaxAreaSortable(height)
    sort.Sort(sort.Reverse(a))
    
    max :=  0
    left, right := a.index[0], a.index[0]
    
    for i := 1; i < a.Len(); i++ {
        h := a.height[i]
        x := a.index[i]
        if x < left {
            left = x
        }
        if right < x {
            right = x
        }
        if h * (right - left) > max {
            max = h * (right - left)
        }
    }
    
    return max
}

type maxAreaSortable struct {
    height []int
    index []int
}

func newMaxAreaSortable(height []int) *maxAreaSortable {
    s := new(maxAreaSortable)
    s.height = height
    s.index = make([]int, len(s.height))
    for i := 0; i < len(s.index); i++ {
        s.index[i] = i
    }
    return s
}

func (s *maxAreaSortable) Len() int {
    return len(s.height)
}

func (s *maxAreaSortable) Less(i, j int) bool {
    return s.height[i] < s.height[j]
}

func (s *maxAreaSortable) Swap(i, j int) {
    s.height[i], s.height[j] = s.height[j], s.height[i]
    s.index[i], s.index[j] = s.index[j], s.index[i]
}
