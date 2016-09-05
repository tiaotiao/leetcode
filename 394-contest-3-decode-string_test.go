package leetcode

import (
	"testing"
)

func TestDecodeString(t *testing.T) {
	s := "2[abc]3[cd]ef3[a2[c]]"
	r := "abcabccdcdcdefaccaccacc"

	a := decodeString(s)

	if r != a {
		t.Error(r, a)
	}
}
