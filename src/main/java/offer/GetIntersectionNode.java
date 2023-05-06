package offer;

public class GetIntersectionNode {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode a1 = new ListNode(1);
        headA.next = a1;
        ListNode headB = new ListNode(5);
        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(1);
        headB.next = b1;
        b1.next = b2;
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        a1.next = c1;
        b2.next = c1;
        c1.next = c2;
        c2.next = c3;
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        System.out.println(getIntersectionNode.getIntersectionNode(headA, headA).val);
        ListNode headAA = new ListNode(2);
        ListNode a11 = new ListNode(6);
        headAA.next = a11;
        ListNode a111 = new ListNode(4);
        a11.next = a111;
        ListNode headBB = new ListNode(1);
        ListNode b11 = new ListNode(5);
        headBB.next = b11;
        System.out.println(getIntersectionNode.getIntersectionNode(headAA, headBB).val);
    }
}
