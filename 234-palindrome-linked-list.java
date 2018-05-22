

class Solution {
    // O(n) with O(1) space
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        // find the middle node
        ListNode end = head, mid = head;
        int count = 1;
        
        while(end.next != null) {
            mid = mid.next;
            end = end.next;
            count += 1;
            if (end.next != null) {
                end = end.next;
                count += 1;
            }
        }
        
        if (count == 1) {
            return true;
        }
        
        int half = count / 2;
        if (count % 2 == 1) {
            mid = mid.next;
        }
        
        // reverse the back half of the list
        ListNode prev = mid;
        ListNode rev = mid.next;
        ListNode next;
        
        while (rev != null) {
            next = rev.next;
            rev.next = prev;
            prev = rev;
            rev = next;
        }
        
        // compare
        ListNode p = head, q = end;
        boolean ok = true;
        for (int i = 0; i < half; i++) {
            if (p.val != q.val) {
                ok = false;
                break;
            }
            p = p.next;
            q = q.next;
        }
        
        // restore list
        // TODO
        
        return ok;
    }
}

