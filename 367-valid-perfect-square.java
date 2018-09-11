
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        
        int left = 2, right = num;
        while (left <= right) {
            int mid = (left + right) / 2;
            int prod = mid * mid;
            
            boolean overflow = false;
            if (prod / mid != mid) overflow = true;
            
            if (overflow || num < prod) {
                right = mid - 1;
            } else if (prod < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}