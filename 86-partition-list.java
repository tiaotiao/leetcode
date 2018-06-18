/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        MyList less = new MyList(), larger = new MyList();
        ListNode p = head;
        ListNode next;
        while (p != null) {
            next = p.next;
            if (p.val < x) {
                // insert to the 'less' list
                less.insert(p);
            } else {
                // insert to the 'larger' list
                larger.insert(p);
            }
            p = next;
        }
        
        if (less.isEmpty()) {
            return larger.head;
        }

        less.tail.next = larger.head;
        return less.head;
    }

    private class MyList {
        public ListNode head;
        public ListNode tail;
        public void insert(ListNode node) {
            if (head == null || tail == null) {
                head = node;
                tail = node;
                tail.next = null;
                return;
            }

            tail.next = node;
            node.next = null;
            tail = node;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }
}
