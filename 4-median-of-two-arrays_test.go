package leetcode 

import "testing"

func TestFindMedianSortedArrays(t *testing.T) {
    nums1 := []int{10, 20, 30, 40, 50}
    nums2 := []int{15, 19, 45, 55, 60, 70}
    result := 40.0
    
    a := findMedianSortedArrays(nums1, nums2)
    
    if a != result {
        t.Error(a, result)
    }
}