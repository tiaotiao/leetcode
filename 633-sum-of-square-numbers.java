

class Solution {
    public boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1) return true;
        
        int m = (int)Math.sqrt(c) + 1;
        
        int[] squares = new int[m];
        for (int i = 0; i < m; i++) {
            squares[i] = i * i;
        }
        
        int left = 0, right = m - 1;
        while (left <= right) {
            int a = squares[left];
            int b = squares[right];
            
            if (a + b == c) return true;
            
            if (a + b < c) left += 1;
            else right -= 1;
        }
        return false;
    }
}