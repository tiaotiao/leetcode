package leetcode 

import "testing"

func Test408ValidWordAbbreviation(t *testing.T) {
    ss := [][]string{
        {"word", "1ord"},
        {"internationalization", "i12iz4n"},
        {"hi", "hi1"},
        {"apple", "a2e"},
    }
    rr := []bool{
        true,
        true,
        false,
        false,
    }
    
    for i, s := range ss {
        r := validWordAbbreviation(s[0], s[1])
        if r != rr[i] {
            t.Error(r, s[0], s[1], rr[i])
        }
    }
}