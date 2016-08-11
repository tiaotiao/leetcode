package leetcode

import (
    "testing"
)

func TestLongestSubstring(t *testing.T) {
    s := "pwwkew"
    a := 3
    
    r := lengthOfLongestSubstring(s)
    
    if a != r {
        t.Error(a, r)
    }
}