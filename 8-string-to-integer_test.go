package leetcode

import (
	"testing"
)

func TestStringToInteger(t *testing.T) {
	tests := []struct {
		str    string
		result int
	}{
		{"123", 123},
		{"-02", -2},
		{"+-3", 0},
		{"  -0012a42", -12},
	}

	for _, test := range tests {
		a := myAtoi(test.str)
		if a != test.result {
			t.Error(test.str, test.result, a)
		}
	}
}
