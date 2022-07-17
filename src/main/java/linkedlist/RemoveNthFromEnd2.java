package linkedlist;

public class RemoveNthFromEnd2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
        ListNode first = dummy, second = dummy;
        n = n + 1;
        for (int i = 0; i < n; i++){
          first = first.next;
        }
        while (first != null) {
          first = first.next;
          second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

  public static void main(String[] args) {
      int n = 2;
      ListNode head = new ListNode(1);
      ListNode node = new ListNode(2);
      ListNode node1 = new ListNode(3);
      ListNode node2 = new ListNode(4);
      ListNode node3 = new ListNode(5);
      head.next = node;
      node.next = node1;
      node1.next = node2;
      node2.next = node3;
    RemoveNthFromEnd2 removeNthFromEnd2 = new RemoveNthFromEnd2();
    removeNthFromEnd2.removeNthFromEnd(head, n);
  }
}
