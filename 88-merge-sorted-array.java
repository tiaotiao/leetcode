/*
https://leetcode.com/problems/merge-sorted-array/description/

88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) 
to hold additional elements from nums2. The number of elements initialized in nums1 
and nums2 are m and n respectively.
*/

import java.util.*;

class Solution {

    private void mergeFromBack(int[] a, int m, int[] b, int n) {
        int i = m-1;
        int j = n-1;

        for (int k = m+n-1; k>=0 && j>=0; k--) {
            if (i >= 0 && a[i] >= b[j]) {
                a[k] = a[i--];
            } else {
                a[k] = b[j--];
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeFromBack(nums1, m, nums2, n);
    }
}
