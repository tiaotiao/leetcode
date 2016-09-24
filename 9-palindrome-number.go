/*
https://leetcode.com/problems/palindrome-number/

9. Palindrome Number

Total Accepted: 150373
Total Submissions: 452773
Difficulty: Easy

Determine whether an integer is a palindrome. Do this without extra space.
*/

package leetcode

func isPalindrome(x int) bool {
    if x < 0 {
        return false
    }

    a := make([]int, 0)
    for x != 0 {
        a = append(a, x % 10)
        x /= 10
    }
    
    for i, j := 0, len(a)-1; i < len(a)/2; i, j = i+1, j-1 {
        if a[i] != a[j] {
            return false
        }
    }
    
    return true
}
