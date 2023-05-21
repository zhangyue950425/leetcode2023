package Hot100;

public class RemoveNthFromEnd {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 两次遍历 暴力解法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode count = head;
        while (count != null) {
            length++;
            count = count.next;
        }
        // 找前驱结点
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        int num = length - n;
        for (int i = 0; i < num; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        //System.out.println(removeNthFromEnd.removeNthFromEnd(head, n));
        System.out.println(removeNthFromEnd.removeNthFromEnd2(head, n));
        head = new ListNode(1);
        n = 1;
        //System.out.println(removeNthFromEnd.removeNthFromEnd(head, n));
        System.out.println(removeNthFromEnd.removeNthFromEnd2(head, n));
    }
}
