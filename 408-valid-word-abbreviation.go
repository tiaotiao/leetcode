/*
https://leetcode.com/contest/7/problems/valid-word-abbreviation/

408. Valid Word Abbreviation

User Accepted: 411
User Tried: 467
Total Accepted: 421
Total Submissions: 1947
Difficulty: Easy

Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.
*/

package leetcode 

func validWordAbbreviation(word string, abbr string) bool {
    w := []byte(word)
    a := []byte(abbr)
    
    isNum := func(c byte) bool {
        return '0' <= c && c <= '9' 
    }
    
    i,j := 0,0
    for ; i < len(a) && j < len(w);  {
        c := a[i]
        d := w[j]
        i++
        j++
        
        if !isNum(c) {
            if c != d {
                return false
            }
        } else {
            num := int(c - '0')
            if num == 0 {
                return false
            }
            for {
                if i < len(a) && isNum(a[i]) {
                    num = num * 10 + int(a[i] - '0')
                    i++
                } else {
                    break
                }
            }
            j += num - 1
        }
    }
    if i != len(a) || j != len(w) {
        return false
    }
    return true
}