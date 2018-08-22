
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> as = new ArrayList<>();
        for (int num: nums) {
            as.add(String.valueOf(num));
        }

        Collections.sort(as, (a, b) -> (b+a).compareTo(a+b));

        if (as.get(0).equals("0")) return "0";

        String str = "";
        for (String a: as) {
            str += a;
        }
        return str;
    }
}