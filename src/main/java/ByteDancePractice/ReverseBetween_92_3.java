package ByteDancePractice;

public class ReverseBetween_92_3 {

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
        ListNode leftPre = dummy;
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
        }
        ListNode leftP = leftPre.next;
        ListNode rightP = leftP;
        for (int i = 0; i < right - left; i++) {
            rightP = rightP.next;
        }
        ListNode rightNext = rightP.next;
        ListNode[] listNodes = reverseList(leftP, rightP);
        leftPre.next = listNodes[0];
        listNodes[1].next = rightNext;
        return dummy.next;

    }

    /**
     * 头插法
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    private ListNode[] reverseList(ListNode head, ListNode tail) {
        if (head == null || tail == null) {
            return new ListNode[]{null, null};
        }
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[] {tail, head};
    }

    public static void main(String[] args) {
        ReverseBetween_92_3 reverseBetween_92_3 = new ReverseBetween_92_3();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2;
        int right = 4;
        //System.out.println(reverseBetween_92_3.reverseBetween(head, left, right));
        System.out.println(reverseBetween_92_3.reverseBetween2(head, left, right));
    }


}
