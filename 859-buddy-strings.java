
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() < 2) return false;

        int diff1 = -1, diff2 = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) continue;
            if (diff1 != -1 && diff2 != -1) return false;
            if (diff1 == -1) diff1 = i;
            else diff2 = i; 
        }

        if (diff1 == -1 && diff2 == -1) {
            Map<Character, Integer> map = new HashMap();
            for (char c : A.toCharArray()) {
                int count = 1 + map.getOrDefault(c, 0);
                if (count >= 2) return true;
                map.put(c, count);
            } 
            return false;
        }
        if (diff1 == -1 || diff2 == -1) return false;

        if (A.charAt(diff1) != B.charAt(diff2) || B.charAt(diff1) != A.charAt(diff2)) {
            return false;
        }
        return true;
    }
}