/*
https://leetcode.com/problems/integer-to-roman/

12. Integer to Roman 

Total Accepted: 81715
Total Submissions: 194904
Difficulty: Medium

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

package leetcode

import "strings"

func intToRoman(num int) string {
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
    str := ""
    for i := len(roman)-1; i >= 0; i-- {
        if roman[i].Num > num {
            continue
        }
        r := roman[i]
        c := num / r.Num
        str += strings.Repeat(r.Letter, c)
        num -= r.Num * c
    }
    
    return str
}
