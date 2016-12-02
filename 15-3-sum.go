/*
https://leetcode.com/problems/3sum/

15. 3Sum

Total Accepted: 164677
Total Submissions: 798680
Difficulty: Medium
Contributors: Admin

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 

Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

package leetcode

import "sort"
import "fmt"

func threeSum(nums []int) [][]int {
    
    sort.Ints(nums)
    
    var m = map[int][][]int{}
    var check = map[string]int{}
    
    add := func(a, b int) {
        x := a + b
        chk := fmt.Sprintf("%d,%d", a, b)
        if _, exist := check[chk]; exist {
            return
        }
        m[x] = append(m[x], []int{a, b})
        check[chk] = x
    }
    
    var result = [][]int{}
    var resultCheck = map[string]bool{}
    
    addResult := func (v []int) {
        chk := fmt.Sprintf("%d,%d,%d", v[0], v[1], v[2])
        if _, exist := resultCheck[chk]; exist {
            return
        }
        result = append(result, v)
        resultCheck[chk] = true
    }
    
    for i, num := range nums {
        vals, ok := m[-num]
        if ok {
            for _, val := range vals {
                addResult(append(val, num))
            }
        }
    
        for j := 0; j < i; j++ {
            add(nums[j], num)
        }
    }
    return result
}

