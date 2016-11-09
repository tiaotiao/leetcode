/*
https://leetcode.com/problems/roman-to-integer/

13. Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

*/


package leetcode

import "strings"

func romanToInt(s string) int {
    var roman = []struct{
        Num int
        Letter string
        Scale bool
    } {
        {1, "I", true},
        {5, "V", false},
        {10, "X", true},
        {50, "L", false},
        {100, "C", true},
        {500, "D", false},
        {1000, "M", true},
    }
    
    // init
    for i := len(roman) - 1; i >= 0; i-- {
        r := roman[i]
        for j := i-1; j >= 0; j-- {
            if roman[j].Scale == true {
                scale := roman[j]
                u := r
                u.Num = u.Num - scale.Num
                u.Letter = scale.Letter + u.Letter
                u.Scale = false
                
                roman = append(roman, u)
                for k := len(roman)-1; k > i; k-- {
                    roman[k] = roman[k-1]
                }
                roman[i] = u
                break
            }
        }
    }
    
    // convert
    num := 0
    
    for s != "" {
        for i := len(roman)-1; i >= 0; i-- {
            r := roman[i]
            if strings.HasPrefix(s, r.Letter) {
                num += r.Num
                s = strings.TrimPrefix(s, r.Letter)
                break
            }
        }
    }
    
    return num
}
