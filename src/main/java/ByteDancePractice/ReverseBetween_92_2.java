package ByteDancePractice;

public class ReverseBetween_92_2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode leftPoint = pre.next;
        ListNode rightPoint = leftPoint;
        for (int i = 0; i < right - left; i++) {
            rightPoint = rightPoint.next;
        }
        ListNode next = rightPoint.next;
        ListNode[] listNodes = reverseList(leftPoint, rightPoint);
        pre.next = listNodes[0];
        listNodes[1].next = next;
        return dummy.next;
    }

    private ListNode[] reverseList(ListNode left, ListNode right) {
        ListNode pre = null;
        ListNode cur = left;
        while (pre != right) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[] {pre, left};
    }

    public static void main(String[] args) {
        ReverseBetween_92_2 reverseBetween_92_2 = new ReverseBetween_92_2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2, right = 4;
        ListNode node = reverseBetween_92_2.reverseBetween(head, left, right);
        System.out.println(node);
        head = new ListNode(5);
        left = right = 1;
        node = reverseBetween_92_2.reverseBetween(head, left, right);
        System.out.println(node);
    }
}
