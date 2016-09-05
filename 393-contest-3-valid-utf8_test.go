package leetcode

import (
	"testing"
)

func TestValidUtf8(t *testing.T) {
	data := []int{19, 240, 130, 138, 147, 17}
	if !validUtf8(data) {
		t.Error(data)
	}
}
