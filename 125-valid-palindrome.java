

class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;

        s = s.replaceAll("[^\\w\\d]", "");
        s = s.toLowerCase();

        for (int i = 0; i < s.length() / 2; i++) {
            int j = s.length() - 1 - i;
            char a = s.charAt(i);
            char b = s.charAt(j);

            if (a != b) return false;
        }
        return true;
    }
}