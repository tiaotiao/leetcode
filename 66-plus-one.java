

class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i]++;
                System.out.println("++++");
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        System.out.println("====" + res.length);
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] digits = new int[]{9, 9};
        int[] result = s.plusOne(digits);

        for (int v: result) {
            System.out.printf("%d ", v);
        }
    }
}