package ByteDancePractice;

public class GetIntersectionNode_160 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA, pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = pointerA != null ? pointerA.next : headB;
            pointerB = pointerB != null ? pointerB.next : headA;
        }
        return pointerA;
    }

    public static void main(String[] args) {
        GetIntersectionNode_160 getIntersectionNode160 = new GetIntersectionNode_160();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode node = new ListNode(8);
        headA.next.next = node;
        ListNode node1 = new ListNode(4);
        headA.next.next.next = node1;
        ListNode node2 = new ListNode(5);
        headA.next.next.next.next = node2;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = node;
        headB.next.next.next.next = node1;
        headB.next.next.next.next.next = node2;
        ListNode result = getIntersectionNode160.getIntersectionNode(headA, headB);
        System.out.println(result != null ? result.val : null);
        headA = new ListNode(2);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(4);
        headB = new ListNode(1);
        headB.next = new ListNode(5);
        result = getIntersectionNode160.getIntersectionNode(headA, headB);
        System.out.println(result != null ? result.val : null);
    }
}
