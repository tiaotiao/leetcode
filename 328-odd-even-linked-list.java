

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode oddHead = new ListNode(-1), oddTail = oddHead;
        ListNode evenHead = new ListNode(-1), evenTail = evenHead;
        
        ListNode p = head, next = null;
        boolean isOdd = true;
        
        while(p != null) {
            next = p.next;
            if (isOdd) {
                oddTail = append(oddTail, p);
            } else {
                evenTail = append(evenTail, p);
            }
            p = next;
            isOdd = !isOdd;
        }
        
        // concat
        append(oddTail, evenHead.next);
        evenTail.next = null;
        
        return oddHead.next;
    }
    
    private ListNode append(ListNode tail, ListNode node) {
        tail.next = node;
        return node;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode oddHead = new ListNode(-1), oddTail = oddHead;
        ListNode evenHead = new ListNode(-1), evenTail = evenHead;
        
        ListNode p = head, next = null;
        boolean isOdd = true;
        
        while(p != null) {
            next = p.next;
            if (isOdd) {
                oddTail = append(oddTail, p);
            } else {
                evenTail = append(evenTail, p);
            }
            p = next;
            isOdd = !isOdd;
        }
        
        // concat
        append(oddTail, evenHead.next);
        evenTail.next = null;
        
        return oddHead.next;
    }
    
    private ListNode append(ListNode tail, ListNode node) {
        tail.next = node;
        return node;
    }
}

