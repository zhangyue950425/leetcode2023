package ByteDancePractice;

public class ReverseBetween_92 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        /*int length = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            length++;
        }
        if (left >= length || right >= length) {
            return head;
        }*/
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode leftPoint = head;
        ListNode rightPoint = head;
        int i = 1, j = 1;
        while (i < left || j <= right) {
            if (i < left) {
                leftPoint = leftPoint.next;
                i++;
            }
            if (j <= right) {
                rightPoint = rightPoint.next;
                j++;
            }
        }
        ListNode cur = leftPoint;
        ListNode pre = null;
        while (cur != rightPoint) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        leftPoint.next = rightPoint;
        p0.next = pre;
        return dummy.next;
    }

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == right || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null, cur = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int left = 2;
        int right = 4;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //ListNode result = ReverseBetween_92.reverseBetween(head, left, right);
        head = new ListNode(5);
        //result = ReverseBetween_92.reverseBetween(head, 1, 1);
        head = new ListNode(3);
        head.next = new ListNode(5);
        ListNode result = ReverseBetween_92.reverseBetween(head, 1, 2);
        //ListNode result = ReverseBetween_92.reverseBetween2(head, 1, 2);

    }
}
