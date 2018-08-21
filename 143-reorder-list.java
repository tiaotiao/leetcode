

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import testing.*;

import java.util.*;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        if (head.next == null) return;
        
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        
        // reorder
        ListNode prev = null;
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            ListNode p = list.get(i);
            ListNode q = list.get(n-i-1);
            if (prev != null) {
                prev.next = p;
            }
            p.next = q;
            prev = q;
        }
        if (n % 2 != 0) {
            prev.next = list.get(n/2);
            prev.next.next = null;
        } else {
            prev.next = null;
        }
    }
}




class Main {
    public static void main(String[] args) {
        ListNode head = Testing.createList(new int[]{1,2,3,4,5});
        Solution s = new Solution();
        s.reorderList(head);
        Testing.printList(head);
    }
}