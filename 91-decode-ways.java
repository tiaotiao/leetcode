
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int curr = 1, prev = 1, next;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char p = '0';
            if (i > 0) p = s.charAt(i-1);

            if (c == '0') {
                next = prev;
                if (p != '1' && p != '2') 
                return 0;
            } else {
                next = curr;
                if (p == '1' || (p == '2' && c <= '6')) {
                next += prev;
               }
            }
            prev = curr;
            curr = next;
            p = c;
        }
        return curr;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "110";
        
        int n = s.numDecodings(str);
        System.out.println(n);
    }
}