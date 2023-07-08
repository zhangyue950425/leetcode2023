package ByteDancePractice;

public class ReorderList_143 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void reorderList(ListNode head) {
        // 找到中间节点
        ListNode mid = getMid(head);
        // 反转中间节点之后的节点链表
        ListNode l2 = reverse(mid.next);
        // 断开中间节点和之后的节点链表
        mid.next = null;
        // 合并两个链表
        merge(head, l2);
    }

    private static ListNode getMid(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode node) {
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

    private static void merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return;
        }
        while (l2 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        ReorderList_143.reorderList(head);
        System.out.println(String.valueOf(head.val) + head.next.val + head.next.next.val
                + head.next.next.next.val);

    }
}
