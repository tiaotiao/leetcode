package leetcode

import "testing"

func Test12IntegerToRoman(t *testing.T) {
    cases := []struct {
        Num int 
        Str string
    } {
        {1, "I"},
        {2, "II"},
        {8, "VIII"},
        {9, "IX"},
        {11, "XI"},
        {18, "XVIII"},
        {19, "XIX"},
        {24, "XXIV"},
        {39, "XXXIX"},
        {44, "XLIV"},
        {62, "LXII"},
        {83, "LXXXIII"},
        {96, "XCVI"},
        {501, "DI"},
        {199, "CXCIX"},
        {707, "DCCVII"},
        {890, "DCCCXC"},
        {1800, "MDCCC"},
        {3999, "MMMCMXCIX"},
    }
    
    
    for i, c := range cases {
        s := intToRoman(c.Num)
        if s != c.Str {
            t.Error(i, c.Num, c.Str, s)
        }
    }
}