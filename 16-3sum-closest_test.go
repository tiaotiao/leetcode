package leetcode

import "testing"

func Test3SumClosest(t *testing.T) {
	cases := []struct {
		nums   []int
		target int
		ans    int
	}{
		{nums: []int{-1, 2, 1, -4}, target: 1, ans: 2},
		{nums: []int{0, 0, 0}, target: 1, ans: 0},
		{nums: []int{1, 1, 1, 0}, target: 100, ans: 3},
		{nums: []int{-3, -2, -5, 3, -4}, target: -1, ans: -2},
	}

	for _, c := range cases {
		a := threeSumClosest(c.nums, c.target)
		if a != c.ans {
			t.Error("Error ", c, a)
		}
	}
}
