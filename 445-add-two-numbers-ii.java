
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        ListNode head = add(l1, len1, l2, len2);
        if (head.val >= 10) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head.val -= 10;
            head = newHead;
        }
        return head;
    }

    private int length(ListNode node) {
        int n = 0;
        while (node != null) {
            n += 1;
            node = node.next;
        }
        return n;
    }

    private ListNode add(ListNode l1, int len1, ListNode l2, int len2) {
        ListNode node = null, next = null;
        if (len1 > len2) {
            node = new ListNode(l1.val);
            next = add(l1.next, len1 - 1, l2, len2);
        } else if (len1 < len2) {
            node = new ListNode(l2.val);
            next = add(l1, len1, l2.next, len2 - 1);
        } else {    // len1 == len2
            node = new ListNode(l1.val + l2.val);
            if (len1 == 1 && len2 == 1) {
                return node;
            }
            next = add(l1.next, len1 - 1, l2.next, len2 - 1);
        }

        if (next.val >= 10) {
            next.val -= 10;
            node.val += 1;
        }
        node.next = next;

        return node;
    }
}
