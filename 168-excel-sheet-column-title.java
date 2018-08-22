

class Solution {
    public String convertToTitle(int n) {
        String str = "";
        
        while (n > 0) {
            char c = intToChar((n-1) % 26 + 1);
            n = (n-1) / 26;

            str = c + str;
        }

        return str;
    }

    private char intToChar(int a) {
        return (char)('A' + a - 1);
    } 
}