/*
https://leetcode.com/contest/6/problems/convert-a-number-to-hexadecimal/

405. Convert a Number to Hexadecimal

User Accepted: 399
User Tried: 435
Total Accepted: 424
Total Submissions: 987
Difficulty: Easy

Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"
*/

package leetcode 

func toHex(num int) string {
    n := uint32(num)
    s := ""
    
    if n < 16 {
        if n < 10 {
            return string('0' + n)
        }
        return string('a' + n - 10)
    }
    
    for n != 0 {
        m := n % 16
        s = toHex(int(m)) + s
        n /= 16
    }
    
    return s
}