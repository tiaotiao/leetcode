/*
https://leetcode.com/problems/string-to-integer-atoi/

8. String to Integer (atoi)

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

package leetcode

import (
	"strings"
)

func myAtoi(str string) int {
	maxint := 2147483647
	minint := -2147483648

	str = strings.TrimSpace(str)

	sign := 1
	if strings.HasPrefix(str, "-") {
		sign = -1
	}

	nums := strings.TrimLeft(str, "+-")
	if len(str)-len(nums) > 1 {
		return 0
	}

	s := []byte(nums)
	if len(s) <= 0 {
		return 0
	}

	num := 0
	for _, c := range s {
		if c < '0' || '9' < c {
			break
		}
		d := int(c - '0')

		if (num*10+d)*sign > maxint {
			return maxint
		}
		if (num*10+d)*sign < minint {
			return minint
		}

		num = num*10 + d
	}

	return num * sign
}
