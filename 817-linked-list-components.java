
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();

        for (int g: G) {
            set.add(g);
        }

        int m = 0;
        boolean ok = false;
        while (head != null) {
            int val = head.val;
            if (set.contains(val)) {
                if (!ok) m += 1;
                ok = true;
            } else {
                ok = false;
            }
            head = head.next;
        }

        return m;
    }
}