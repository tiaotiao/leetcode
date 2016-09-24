package leetcode

import "testing"

func TestIsPalindrome(t *testing.T) {
    x := 12300
    r := false
    
    a := isPalindrome(x)
    if a != r {
        t.Error(x, a, r)
    }
}