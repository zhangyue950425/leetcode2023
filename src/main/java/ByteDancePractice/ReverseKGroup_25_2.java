package ByteDancePractice;

public class ReverseKGroup_25_2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
                ListNode[] reverseList = reverseList(head, tail);
                head = reverseList[0];
                tail = reverseList[1];
                pre.next = head;
                pre = tail;
                head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode p = tail.next;
        ListNode cur = head;
        while (p != tail) {
            ListNode next = cur.next;
            cur.next = p;
            p = cur;
            cur = next;
        }
        return new ListNode[] {tail, head};
    }

    private ListNode reverse(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseKGroup_25_2 reverseKGroup252 = new ReverseKGroup_25_2();
        int k = 2;
        /*ListNode result = reverseKGroup252.reverseKGroup(head, k);
        ListNode cur = result;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }*/
        k = 1;
        ListNode result = reverseKGroup252.reverseKGroup(head, k);
        ListNode cur = result;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }


}
