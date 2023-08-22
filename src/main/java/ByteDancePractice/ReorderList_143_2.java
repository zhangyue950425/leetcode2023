package ByteDancePractice;

public class ReorderList_143_2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 找链表中点位置
     * 中点后所有节点反转
     * 两个链表合并
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode mid = getMid(head);
        ListNode head2 = reverseListNode(mid.next);
        merge(head, head2);
        mid.next = null;
    }

    private ListNode getMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private void merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return;
        }
        while (head2 != null) {
            ListNode p1 = head1.next;
            ListNode p2 = head2.next;
            head1.next = head2;
            head2.next = p1;
            head1 = p1;
            head2 = p2;
        }
    }

    public static void main(String[] args) {
        ReorderList_143_2 reorderList_143_2 = new ReorderList_143_2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList_143_2.reorderList(head);
        System.out.println(head.val);
    }


}
