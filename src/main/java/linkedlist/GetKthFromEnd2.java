package linkedlist;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head, second = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        int k = 2;
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        GetKthFromEnd2 getKthFromEnd2 = new GetKthFromEnd2();
        getKthFromEnd2.getKthFromEnd(head, k);
    }
}
