class Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int k = D.length;
        
        int[] d = new int[k];
        for (int i = 0; i < k; i++) {
            d[i] = D[i].toCharArray()[0] - '0';
        }
        
        int[] pow = new int[10];
        pow[0] = 1;
        for (int i = 1; i < 10; i++) {
            pow[i] = pow[i-1] * k;
            // System.out.println(i + " " + pow[i]);
        }
        
        int total = 0, p = 0;
        int[] a = new int[10];
        int[] b = new int[10];
        
        // boolean allFound = true;
        
        while (N > 0) {
            int num = N % 10;
            N /= 10;
            
            int i = 0;
            for (; i < k; i++) {
                if (d[i] >= num) {
                    break;
                }
            }
            
            a[p] = num;
            b[p] = i;
            
            // total += pow[p] * i;
            if (p >= 1) total += pow[p];
            
            p += 1;
        }
        
        // if (allFound) total += 1;
        
        int q = p - 1;
        for (; q >= 0; q--) {
            int i = b[q];
            if (i < k && a[q] == d[i]) {
                total += pow[q] * i;
                continue;
            }
            total += pow[q] * i;
            break;
        }
        
        if (q == -1) total += 1;
        
        return total;
    }
}