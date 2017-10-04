/*
https://leetcode.com/problems/3sum-closest/description/

Given an array S of n integers, find three integers in S such
that the sum is closest to a given number, target. Return the
sum of the three integers. You may assume that each input
would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

package leetcode

import (
	"sort"
)

//import "fmt"

func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)

	//fmt.Printf("%v\n", nums)

	var sum2 map[int][2]int
	sum2 = make(map[int][2]int, len(nums)*len(nums))

	for i, a := range nums {
		for j := 0; j < i; j++ {
			b := nums[j]
			_, exist := sum2[a+b]
			if exist {
				//delete(sum2, a+b)
			} else {
				sum2[a+b] = [2]int{j, i}
			}
		}
	}

	closest := nums[0] + nums[1] + nums[2]

	abs := func(x int) int {
		if x < 0 {
			return -x
		}
		return x
	}

	bsearch := func(a []int, x int) int { // search for the closest number to x
		l, r := 0, len(a)-1
		c := 0
		for {
			m := (l + r) / 2
			if a[m] < x {
				l = m + 1
			} else if a[m] > x {
				r = m - 1
			} else {
				return m
			}
			if abs(x-a[m]) < abs(x-a[c]) {
				c = m
			}
			if l > r {
				break
			}
		}
		return c
	}

	bsearch_without := func(a []int, x int, ex [2]int) int {
		c := bsearch(a, x)
		n := len(a)

		k := -1
		for i := c; i >= 0; i-- {
			if i == ex[0] || i == ex[1] {
				continue
			}
			k = i
			break
		}
		for j := c + 1; j < n; j++ {
			if j == ex[0] || j == ex[1] {
				continue
			}
			if k == -1 {
				k = j
			} else if abs(a[k]-x) > abs(a[j]-x) {
				k = j
			}
			break
		}

		//fmt.Printf("bsearch %v, %v = %v, %v\n", x, ex, c, k)
		return k
	}

	for ab, ij := range sum2 {
		k := bsearch_without(nums, target-ab, ij)
		sum := ab + nums[k]

		//fmt.Printf("[%d, %d, %d]: %d, %d, %d = %d\n", ij[0], ij[1], k, nums[ij[0]], nums[ij[1]], nums[k], sum)

		if target-sum == 0 {
			return target
		}

		if abs(target-sum) < abs(target-closest) {
			closest = sum
		}
	}

	return closest
}
