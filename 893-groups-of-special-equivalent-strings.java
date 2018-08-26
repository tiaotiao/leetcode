
import java.util.*;

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: A) {
            String rep = represent(s);
            List<String> list = map.getOrDefault(rep, new ArrayList<>());
            list.add(s);
            map.put(rep, list);
        }
        return map.size();
    }

    private String represent(String s) {
        if (s.length() <= 1) return s;
        char[] cs = s.toCharArray();
        int n = cs.length / 2;
        int m = cs.length / 2;
        if (cs.length % 2 == 1) n += 1;
        char[] c0 = new char[n];
        char[] c1 = new char[m];
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (i % 2 == 0) {
                c0[i/2] = c;
            } else {
                c1[i/2] = c;
            }
        }

        Arrays.sort(c0);
        Arrays.sort(c1);

        String s0 = new String(c0);
        String s1 = new String(c1);
        return s0 + "#" + s1;
    }
}