
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return solution_binary_guess(nums1, nums2);
    }

    private double solution_kth_smallest_divide_and_conquer(int[] nums1, int[] nums2) {

    }

    private int kth_smallest(int k, int[] nums1, int idx1, int[] nums2, int idx2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n + m <= k) return -1;
        
    }

    // private double solution_dropoff_one_fourth(int[] nums1, int[] nums2) {
    // }

    ///////////////////////////////////////////////////////////////
    // Guess a value, see if the value is the median. Use binary search to guess the answer.
    // O(log(m+n)^2)
    private double solution_binary_guess(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        if (nums1.length > 0) {
            max = Math.max(max, nums1[nums1.length - 1]);
            min = Math.min(min, nums1[0]);
        }
        if (nums2.length > 0) {
            max = Math.max(max, nums2[nums2.length - 1]);
            min = Math.min(min, nums2[0]);
        }
        
        int total = nums1.length + nums2.length;
        int mid = total / 2;
        int median = bsearch_kth(nums1, nums2, min, max, mid);
        System.out.println(">median " + mid + ": " + median);
        if (total % 2 == 1) {
            return median;
        }
        median += bsearch_kth(nums1, nums2, min, max, mid - 1);
        System.out.println("<median " + (mid-1) + ": " + median);
        return median / 2.0;
    }
    
    private int bsearch_kth(int[] nums1, int[] nums2, int min, int max, int k) {
        while (min < max) {
            int val = (max + min + 1) / 2;
            int less = bsearch(nums1, nums2, val);
            boolean found = true;
            if (less < 0) {
                found = false;
                less = -less-1;
            }
            if (less == k && found) return val;
            if (less == k) min = val + 1;
            if (less < k) min = val;
            if (k < less) max = val-1;
        }
        return min;
    }

    private int bsearch(int[] nums1, int[] nums2, int val) {
        // return the # of items less than val
        int c1 = Arrays.binarySearch(nums1, val);
        int c2 = Arrays.binarySearch(nums2, val);
        boolean found = false;
        if (c1 < 0) c1 = -c1 - 1; else found = true;
        if (c2 < 0) c2 = -c2 - 1; else found = true;
        int less = c1 + c2;
        if (!found) return -less-1;
        return less;
    }
}
