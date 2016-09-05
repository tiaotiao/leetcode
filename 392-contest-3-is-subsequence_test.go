package leetcode

import (
	"testing"
)

func TestContestIsSubsequence(t *testing.T) {
	s := "abc"
	d := "ahbgdc"

	if !isSubsequence(s, d) {
		t.Error(s, d)
	}
}
