package linkedlist;

public class AddTwoNumbers2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(-1);
      ListNode p = dummy;
      int bit = 0;
      while (l1 != null || l2 != null || bit > 0) {
        int result = bit;
        if (l1 != null) {
          result = result + l1.val;
          l1 = l1.next;
        }
        if (l2 != null) {
          result = result + l2.val;
          l2 = l2.next;
        }
        bit = result / 10;
        result = result % 10;
        p.next = new ListNode(result);
        p = p.next;
      }
      return dummy.next;
    }

  public static void main(String[] args) {
      // l1 = [2,4,3], l2 = [5,6,4]
    // l1 = [0], l2 = [0]
    // l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
    addTwoNumbers2.addTwoNumbers(l1, l2);
    l1 = new ListNode(9);
    l1.next = new ListNode(9);
    l1.next.next = new ListNode(9);
    l1.next.next.next = new ListNode(9);
    l1.next.next.next.next = new ListNode(9);
    l1.next.next.next.next.next = new ListNode(9);
    l1.next.next.next.next.next.next = new ListNode(9);
    l2 = new ListNode(9);
    l2.next = new ListNode(9);
    l2.next.next = new ListNode(9);
    l2.next.next.next = new ListNode(9);
    addTwoNumbers2.addTwoNumbers(l1, l2);
    l1 = new ListNode(0);
    l2 = new ListNode(0);
    addTwoNumbers2.addTwoNumbers(l1, l2);

    }
}
