
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return solution_dropoff_one_fourth(nums1, nums2);
    }

    ///////////////////////////////////////////////////////////////////////////

    private double solution_dropoff_one_fourth(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int n = len1 + len2;

        if (n % 2 == 1) {
            return search_kth(n/2, nums1, 0, len1-1, nums2, 0, len2-1);
        } else {
            int x = search_kth(n/2, nums1, 0, len1-1, nums2, 0, len2-1);
            int y = search_kth(n/2-1, nums1, 0, len1-1, nums2, 0, len2-1);
            // System.out.println("xy:" + x + " " + y);
            return (x+y) / 2.0;
        }
    }

    private int search_kth(int k, int[] nums1, int l1, int r1, int[] nums2, int l2, int r2) {
        
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;

        // System.out.printf("search %d: [%d-%d](%d);  [%d-%d](%d)\n",k, l1, r1, len1, l2, r2, len2);

        
        if (len1 <= 0) {
            return nums2[l2+k];
        }
        if (len2 <= 0) {
            return nums1[l1+k];
        }
        
        
        int m1 = (l1+r1) / 2;
        int m2 = (l2+r2) / 2;
        int mid1 = nums1[m1];
        int mid2 = nums2[m2];
        
        int leftSide = (m1-l1) + (m2-l2) + 1;

        if (k >= leftSide) {
            // dropoff one of the left side
            if (mid1 < mid2) {
                return search_kth(k - (m1-l1+1), nums1, m1+1, r1, nums2, l2, r2);
            } else {
                return search_kth(k - (m2-l2+1), nums1, l1, r1, nums2, m2+1, r2);
            }
        } else { // k < leftSide
            // dropoff one of the right side
            if (mid1 < mid2) {
                return search_kth(k, nums1, l1, r1, nums2, l2, m2-1);
            } else {
                return search_kth(k, nums1, l1, m1-1, nums2, l2, r2);
            }
        }
    }

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
