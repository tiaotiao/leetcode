/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

19. Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int i = remove(head, n);
        if (i == n) {
            head = head.next;
        }

        return head;
    }

    private int remove(ListNode p, int n) {
        if (p.next == null) {
            return 1;
        }

        int i = remove(p.next, n);

        if (i == n) {
            p.next = p.next.next;
        }

        return i + 1;
    }
}

///////////////////////////////////////////////////////////

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}