/*
https://leetcode.com/contest/4/problems/random-pick-index/

398. Random Pick Index

User Accepted: 243
User Tried: 411
Total Accepted: 264
Total Submissions: 2116
Difficulty: Medium

Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
*/

package leetcode

import "math/rand"

type Solution struct {
    m map[int][]int
}


func Constructor(nums []int) Solution {
    count := make(map[int]int)
    for _, x := range nums {
        count[x] += 1
    }
    
    s := new(Solution)
    s.m = make(map[int][]int, len(count))
    for i, x := range nums {
        list := s.m[x]
        if list == nil {
            list = make([]int, 0, count[x])
        }
        s.m[x] = append(list, i)
    }
    return *s
}


func (s *Solution) Pick(target int) int {
    return s.m[target][rand.Intn(len(s.m[target]))]
}


/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.Pick(target);
 */