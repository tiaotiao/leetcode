

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode node = head;
        
        while (node != null) {
            boolean remove = false;
            while (node.next != null) {
                if (node.next.val == node.val) {
                    remove = true;
                    node.next = node.next.next;
                } else {
                    break;
                }
            }
            if (remove) {
                prev.next = node.next;
                node = node.next;
            } else {
                prev = node;
                node = node.next;
            }
        }

        return dummy.next;
    }
}
