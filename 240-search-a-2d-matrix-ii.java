
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
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