/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    
    private class CountRes {
        int count;
        ListNode tail;
    }
    
    private CountRes countNodes(ListNode head) {
        CountRes r = new CountRes();
        r.count = 0;
        r.tail = null;
        
        while (head != null) {
            r.count += 1;
            r.tail = head;
            head = head.next;
        }
        return r;
    }
    
    private ListNode skip(ListNode head, int count) {
        while (count > 0) {
            head = head.next;
            count --;
        }
        return head;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        CountRes ra = countNodes(headA);
        CountRes rb = countNodes(headB);
        
        if (ra.count <= 0 || rb.count <= 0) {
            return null;
        }
        if (ra.tail != rb.tail) {
            return null;
        }
        
        if (ra.count > rb.count) {
            headA = skip(headA, ra.count - rb.count);
        } else {
            headB = skip(headB, rb.count - ra.count);
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

