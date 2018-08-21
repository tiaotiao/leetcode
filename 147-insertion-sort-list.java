

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;

        ListNode node = head.next, prev = head;
        while (node != null) {
            if (prev.val <= node.val) {
                prev = node;
                node = node.next;
                continue;
            }

            prev.next = node.next;
            
            // insert at head
            if (node.val <= head.val) {
                node.next = head;
                head = node;
                
                node = prev.next;
                continue;
            }
            
            // find a correct position
            ListNode p = head;
            while (p.next.val < node.val) {
                p = p.next;
            }
            node.next = p.next;
            p.next = node;

            node = prev.next;
        }

        return head;
    }
}
