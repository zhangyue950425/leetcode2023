package ByteDancePractice;

public class ReverseKGroup_25_3 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                if (tail.next == null) {
                    break;
                }
                tail = tail.next;
                // 不足k个节点
               /* if (tail == null) {
                    return dummy.next;
                }*/

            }
            // 反转链表
            ListNode[] listNodes = reverseList(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            pre.next = head;
            head = tail.next;
            pre = tail;
        }
        return dummy.next;
    }

    private ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[] {tail, head};
    }

    public static void main(String[] args) {
        ReverseKGroup_25_3 reverseKGroup_25_3 = new ReverseKGroup_25_3();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode node = reverseKGroup_25_3.reverseKGroup(head, k);
        System.out.println(node.val);
    }
}
