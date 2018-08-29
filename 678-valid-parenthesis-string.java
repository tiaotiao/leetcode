
class Solution {
    public boolean checkValidString(String s) {
        int countLeft = 0;
        int starLeft = 0;
        int starRight = 0;

        for (char c : s.toCharArray()) {
            if (c == '*') {
                starLeft += 1;
                starRight += 1;
            }
            if (c == '(') {
                countLeft += 1;
            }
            if (c == ')') {
                if (countLeft > 0) {
                    countLeft -= 1;
                    starRight = Math.min(starRight, countLeft);
                } else if (starLeft > 0) {
                    starLeft -= 1;
                } else {
                    return false;
                }
            }
        }

        if (countLeft > starRight) return false;
        return true;
    }
}