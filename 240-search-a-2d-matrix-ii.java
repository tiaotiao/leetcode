
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return solution_binary_search(matrix, target);
    }


    ////////////////////////////////////////////////////////////////////////
    // O(logm + logn)
    private boolean solution_binary_search(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;

        return solution_bsearch(matrix, 0, 0, n-1, m-1, target);
    }

    private boolean solution_bsearch(int[][] matrix, int top, int left, int bottom, int right, int target) {
        if (target < matrix[top][left]) return false;
        if (matrix[bottom][right] < target) return false;

        // search fist row
        if (top > bottom || left > right) return false;
        final int tp = top;
        int firstRow = bsearch(matrix, left, right, target, (mt, i) -> (mt[tp][i]));
        if (firstRow < 0) return true;
        right = firstRow - 1;

        // search first col
        if (top > bottom || left > right) return false;
        final int lt = left;
        int firstCol = bsearch(matrix, top, bottom, target, (mt, i) -> (mt[i][lt]));
        if (firstCol < 0) return true;
        bottom = firstCol - 1;

        // search last row
        if (top > bottom || left > right) return false;
        final int bt = bottom;
        int lastRow = bsearch(matrix, left, right, target, (mt, i) -> (mt[bt][i]));
        if (lastRow < 0) return true;
        left = lastRow;

        // search last col
        if (top > bottom || left > right) return false;
        final int rt = right;
        int lastCol = bsearch(matrix, top, bottom, target, (mt, i) -> (mt[i][rt]));
        if (lastCol < 0) return true;
        top = lastCol;

        return solution_bsearch(matrix, top, left, bottom, right, target);
    }

    private int bsearch(int[][] matrix, int start, int end, int target, ItemGetter item) {
        while (start < end) {
            int mid = (start + end) / 2;
            int val = item.get(matrix, mid);
            if (val == target) return -mid-1;
            if (val < target) start = mid + 1;
            if (target < val) end = mid - 1;
        }
        int val = item.get(matrix, start);
        if (val == target) return -start-1;
        if (val < target) start += 1;
        return start;
    }

    interface ItemGetter {
        public int get(int[][] matrix, int idx);
    }

    //////////////////////////////////////////////////////////
    // 
    // O(m + n)
    public boolean solution_stepdown(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        
        int i = 0, j = m-1;
        while (i < n && 0 <= j) {
            if (matrix[i][j] == target) return true;
            if (0 < j && matrix[i][j-1] <= target) j -= 1;
            else i += 1;
            // if (i < n-1 && matrix[i+1][j] > target) j -= 1;
        }
        return false;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        // int[][] matrix = {
        //     {1,   4,  7, 11, 15},
        //     {2,   5,  8, 12, 19},
        //     {3,   6,  9, 16, 22},
        //     {10, 13, 14, 17, 24},
        //     {18, 21, 23, 26, 30}
        // };
        // int target = 20;
        int[][] matrix = {{1,2,3,4,5},
        {6,7,8,9,10},
        {11,12,13,14,15},
        {16,17,18,19,20},
        {21,22,23,24,25}};
        int target = 19;

        boolean res = s.searchMatrix(matrix, target);

        System.out.println(res);
    }
}
