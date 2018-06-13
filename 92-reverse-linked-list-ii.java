/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
*/

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m >= n) {
            return head;
        }
        
        ListNode node = head, prev = node, next;
        ListNode before = null, after = null;
        
        int index = 0;
        while(node != null) {
            index += 1;
            next = node.next;

            if (index == m - 1) {
                before = node;
            }
            if (index == n + 1) {
                after = node;
            }

            // reverse
            if (m <= index && index <= n) {
                node.next = prev;
            }

            // to next node
            prev = node;
            node = next;
        }
    }
}
