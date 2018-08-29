
class Solution {
    public String toGoatLatin(String S) {
        String[] ss = S.split(" ");
        int n = ss.length;

        StringBuilder a = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) result.append(' ');
            String word = ss[i];

            a.append('a');

            // convert word
            char[] w = word.toCharArray();
            if ("aeiouAEIOU".indexOf(w[0]) < 0) {
                result.append(w, 1, w.length - 1);
                result.append(w[0]);
            } else {
                result.append(w);
            }

            result.append("ma");

            result.append(a);
        }

        return result.toString();
    }
}
