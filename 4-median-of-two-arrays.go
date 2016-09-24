/*
https://leetcode.com/problems/median-of-two-sorted-arrays/

4. Median of Two Sorted Arrays

Total Accepted: 116610
Total Submissions: 583586
Difficulty: Hard

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

package leetcode

import (
    "sort"
    "fmt"
)

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    a1 := newMedianArray(nums1)
    a2 := newMedianArray(nums2)
    
    total := len(nums1) + len(nums2)
    if total == 0 {
        return 0.0
    }
    
    var median = float64(findNthSortedArrays(a1, a2, total / 2))

    if total % 2 == 0 {
        a1.reset()
        a2.reset()
        median += float64(findNthSortedArrays(a1, a2, total / 2 - 1))
        median /= 2
    }
    
    return median
}

func findNthSortedArrays(a1 *medianArray, a2 *medianArray, n int) int { // n ~ [0, m+n)
    for i := 0; i < len(a1.nums) + len(a2.nums); i++ {
        
        ifSeparated := func() (bool, int) {
            if a1.length() <= 0 {
                return true, a2.nth(n)
            }
            if a2.length() <= 0 {
                return true, a1.nth(n)
            }
            if a1.nums[a1.right] <= a2.nums[a2.left] {
                if n < a1.length() {
                    return true, a1.nth(n)
                }
                return true, a2.nth(n - a1.length())
            }
            if a2.nums[a2.right] <= a1.nums[a1.left] {
                if n < a2.length() {
                    return true, a2.nth(n)
                }
                return true, a1.nth(n - a2.length())
            }
            return false, 0
        }
        
        if ok, value := ifSeparated(); ok {
            return value
        }
        
        l1, m1, r1 := a1.findRanges(a2)
        l2, m2, r2 := a2.findRanges(a1)
        
        leftSize, midSize, _ := l1+l2, m1+m2, r1+r2
        
        //println(">>>>>> a1", a1.String(), "a2", a2.String())
        //println(">>>>>>", n ," sizes", leftSize, midSize, r1 + r2)
        
        if n < leftSize  {
            a1.setRange("left")
            a2.setRange("left")
        } else if (n < leftSize + midSize) {
            a1.setRange("middle")
            a2.setRange("middle")
            n -= leftSize
        } else {
            a1.setRange("right")
            a2.setRange("right")
            n -= leftSize + midSize
        }
    }
    return -1
}

type medianArray struct {
    nums []int
    left, right int
    middleLeft, middleRight int
}

func newMedianArray(nums []int) *medianArray {
    a := new(medianArray)
    a.nums = nums
    a.reset()
    return a
}

func (a *medianArray) String() string {
    return fmt.Sprintf("[%v - (%v %v) - %v]", a.left, a.middleLeft, a.middleRight, a.right)
}

func (a *medianArray) reset() {
    a.left = 0
    a.right = len(a.nums) -1
    a.middleLeft = -1
    a.middleRight = -1
}

func (a *medianArray) nth(n int) int {
    return a.nums[a.left + n]
}

func (a *medianArray) length() int {
    if a.left > a.right {
        return 0
    }
    return a.right - a.left + 1
}

func (a *medianArray) middle() int {
    if a.length() <= 0 {
        return -1
    }
    return (a.left + a.right) / 2
}

func (a *medianArray) middleValue() int {
    mid := a.middle()
    if mid == -1 {
        return 0
    }
    return a.nums[mid]
}

func (a *medianArray) ranges() (int, int, int) {
    if a.length() <= 0 {
        return 0, 0, 0
    }
    
    leftSize := a.middleLeft - a.left 
    midSize := a.middleRight - a.middleLeft + 1
    rightSize := a.right - a.middleRight
    
    return leftSize, midSize, rightSize
}

func (a *medianArray) setRange(side string) {
    if side == "middle" {
        a.left = a.middleLeft
        a.right = a.middleRight
    } else if side == "left" {
        a.right = a.middleLeft - 1
    } else if side == "right" {
        a.left = a.middleRight + 1
    }
}

func (a *medianArray) findRanges(other *medianArray) (int, int, int) {
    if a.length() <= 0 {
        a.middleLeft, a.middleRight = -1, -1
        return a.ranges()
    }
    
    if other.length() <= 0 {
        a.middleLeft, a.middleRight = a.middle(), a.middle()
        return a.ranges()
    }
    
    otherMid := other.middleValue()
    
    mid := a.nums[a.middle()]
    side := otherMid - mid
    
    if side == 0 {
        a.middleLeft = a.middle()
        a.middleRight = a.middle()
        return a.ranges()
    }
    
    pos := sort.Search(a.length(), func (i int) bool {
        if side < 0 {
            return otherMid <= a.nums[a.left + i]
        } else {
            return a.nums[a.right - i] <= otherMid
        }
    })
    
    if side > 0 {
        a.middleLeft = a.middle()
        a.middleRight = a.right
    } else {
        a.middleLeft = a.left
        a.middleRight = a.middle()
    }
    
    if pos < a.length() {
        if side > 0 {
            a.middleRight = a.right - pos
        } else {
            a.middleLeft = a.left + pos
        }
    }
    
    return a.ranges()
}

