/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
*/


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode node = head, prev = null, next = null;
        while(node != null) {
            next = node.next;
            // reverse link
            node.next = prev;

            // move to next node
            prev = node;
            node = next;
        }
        return prev;
    }
}