/*
https://leetcode.com/problems/reverse-integer/

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

package leetcode 

func reverse(x int) int {
    var y = 0
    
    for x != 0 {
        if -2147483648 > y * 10 + x % 10 || y * 10 + x % 10 > 2147483647 {
            return 0
        }
        y = y * 10 + x % 10
        x /= 10
    }
    
    return y
}