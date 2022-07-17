package linkedlist;

public class AddTwoNumbers {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      int carry = 0;
      while (l1 != null || l2 != null) {
        int v1 = l1 == null ? 0 : l1.val;
        int v2 = l2 == null ? 0 : l2.val;
        int sum = v1 + v2 + carry;
        carry = sum / 10;
        int num = sum % 10;
        cur.next = new ListNode(num);
        cur = cur.next;
        if (l1 != null) {
          l1 = l1.next;
        }
        if (l2 != null) {
          l2 = l2.next;
        }
      }
      if (carry == 1) {
        cur.next = new ListNode(carry);
      }
      return dummy.next;
    }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(7);
    ListNode l11 = new ListNode(8);
    ListNode l111 = new ListNode(9);
    l1.next = l11;
    l11.next = l111;
    ListNode l2 = new ListNode(3);
    ListNode l22 = new ListNode(2);
    l2.next = l22;
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    addTwoNumbers.addTwoNumbers(l1, l2);
  }
}
