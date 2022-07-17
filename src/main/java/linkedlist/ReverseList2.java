package linkedlist;

/**
 * 反转链表，迭代方法
 */
public class ReverseList2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        ReverseList2 reverseList2 = new ReverseList2();
        reverseList2.reverseList(head);
    }
}
