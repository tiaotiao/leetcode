package leetcode

import (
	"testing"
)

func TestLongestSubstringWithK(t *testing.T) {
	s := "hadccccccddddcccccddddddccccccccdddddddeeffgglhkj"
	k := 7
	r := 37

	c := longestSubstring(s, k)

	if c != r {
		t.Error(r, c)
	}
}
