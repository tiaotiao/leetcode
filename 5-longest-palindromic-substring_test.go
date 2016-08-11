package leetcode

import (
    "testing"
)

func TestLongestPalindrome(t *testing.T) {
    s := "ximmnm=abcdedcba_ymmnxi"
    a := "abcdedcba"
    
    r := longestPalindrome(s)
    
    if a != r {
        t.Error(r, a)
    }
}