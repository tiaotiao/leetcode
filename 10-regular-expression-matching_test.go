package leetcode

import "testing"

func Test10RegularExpressionMatching(t *testing.T) {
    cases := []struct {
       s string
       p string
       ok bool
    }{
        {"aa", "a", false},
        {"aa", "aa", true},
        {"aaa", "a*", true},
        {"aa", ".*", true},
        {"aab", "c*a*b", true},
        {"a", "ab*", true},
        {"abaaac", "ac*b.*ac", true},
        {"abaaac", "ac*b.*ca", false},
    }
    
    for i, c := range cases {
        if isMatch(c.s, c.p) != c.ok {
            t.Error(i, ":", c.s, c.p, c.ok)
        }
    }
}