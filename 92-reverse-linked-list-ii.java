

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) 
            return null;

        ListNode prev=null, post=head.next, p=head, q=null;
        // find the starting position m
        for (int i = 1; i < m; i++) {
            prev = p;
            p = p.next;
            post = p.next;
        }
        // reverse the middle
        ListNode start = p;
        // System.out.println("Start " + p.val);
        for (int i = 0; i < n - m; i++) {
            q = p;
            p = post;
            post = p.next;
            p.next = q;
            // System.out.println(q.val + " <- " + p.val);
        }
        ListNode end = p;
        // System.out.println("End "+ p.val);
        // connect prev and post
        start.next = post;
        if (prev != null) {
            prev.next = end;
        } else {
            head = end;
        }
        return head;
    }
}


class Main {
    public static ListNode createList(int[] list) {
        ListNode head = null;
        ListNode tail = null;

        for (int a: list) {
            ListNode node = new ListNode(a);
            if (head == null || tail == null) {
                head = node;
                tail = node;
                continue;
            }
            tail.next = node;
            tail = node;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = createList(new int[]{3,5});

        ListNode newList = s.reverseBetween(head, 1, 2);

        printList(newList);
    }
}
