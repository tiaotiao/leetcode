package testing;

public class Testing {
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
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
