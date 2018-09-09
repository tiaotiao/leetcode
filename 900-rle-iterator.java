
class RLEIterator {
    private int[] A;
    private int len, index;
    
    
    public RLEIterator(int[] A) {
        this.A = A;
        this.len = A.length;
        this.index = 0;
    }
    
    public int next(int n) {
        int val = -1;
        
        while (n > 0 && index < len) {
            if (n <= A[index]) {
                A[index] -= n;
                n = 0;
                val = A[index+1];
            } else {
                n -= A[index];
                index += 2;
            }
        }
        
        return val;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */