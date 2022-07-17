package linkedlist;

public class MergeTwoLists2 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(-1);
      ListNode p = dummy, p1 = l1, p2 = l2;
      while (p1 != null && p2 != null) {
        if (p1.val > p2.val) {
          p.next = p2;
          p2 = p2.next;
        } else {
          p.next = p1;
          p1 = p1.next;
        }
        p = p.next;
      }
      if (p1 != null) {
        p.next = p1;
      }
      if (p2 != null) {
        p.next = p2;
      }
      return dummy.next;
    }

  public static void main(String[] args) {
      ListNode l1 = new ListNode(1);
      ListNode l11 = new ListNode(2);
      ListNode l111 = new ListNode(4);
      l1.next = l11;
      l11.next = l111;
      ListNode l2 = new ListNode(1);
      ListNode l22 = new ListNode(3);
      ListNode l222 = new ListNode(4);
      l2.next = l22;
      l22.next = l222;
    MergeTwoLists2 mergeTwoLists2 = new MergeTwoLists2();
    mergeTwoLists2.mergeTwoLists(l1, l2);
  }
}
