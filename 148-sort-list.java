
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    class HeadTail {
        public ListNode head;
        public ListNode tail;
        public HeadTail(ListNode h, ListNode t) {
            this.head = h;
            this.tail = t;
        }
    }
    
    public ListNode sortList(ListNode head) {
        HeadTail list = sort(head, null);
        return list.head;
    }

    private HeadTail sort(ListNode head, ListNode end) {
        if (head == end) return null;
        if (head.next == end) {
            return new HeadTail(head, head);
        }

        ListNode pivot = head, node = pivot.next, prev = pivot, next=null;
        while (node != end) {
            if (pivot.val <= node.val) {
                prev = node;
                node = node.next;
                continue;
            }
            // insert node to head
            prev.next = node.next;

            node.next = head;
            head = node;

            node = prev.next;
        }
        ListNode tail = prev;

        HeadTail left = sort(head, pivot);
        HeadTail right = sort(pivot.next, end);

        if (left != null) {
            left.tail.next = pivot;
            head = left.head;
        } else {
            head = pivot;
        }

        if (right != null) {
            pivot.next = right.head;
            tail = right.tail;
        } else {
            tail = pivot;
        }

        return new HeadTail(head, tail);
    }
}