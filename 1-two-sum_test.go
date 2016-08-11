package leetcode

import (
	"reflect"
	"testing"
)

func TestTwoSum(t *testing.T) {
	c := []int{2, 7, 11, 15}
	r := []int{0, 1}

	a := twoSum(c, 9)

	if !reflect.DeepEqual(a, r) {
		t.Error("twoSum", a, r)
	}
}
