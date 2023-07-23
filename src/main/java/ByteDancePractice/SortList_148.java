package ByteDancePractice;

public class SortList_148 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 迭代快排
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        return quickSort(head);
    }

    /**
     * 第一次partition选取中间的节点进行大小比较，快慢指针寻找中点位置
     * @param head
     */
    private static ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        int pivotVal = slow.val;
        ListNode h1 = new ListNode();
        ListNode h3 = new ListNode();
        ListNode h2 = new ListNode();
        ListNode t1 = h1, t3 = h3, t2 = h2, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < pivotVal) {
                cur.next = t1.next;
                t1.next = cur;
                t1 = t1.next;
            } else if (cur.val == pivotVal) {
                cur.next = t3.next;
                t3.next = cur;
                t3 = t3.next;
            } else {
                // cur.val > pivotVal
                cur.next = t2.next;
                t2.next = cur;
                t2 = t2.next;
            }
            cur = next;
        }
        h1 = quickSort(h1.next);
        h2 = quickSort(h2.next);
        h3 = h3.next;
        t3.next = h2;
        if (h1 == null) {
            return h3;
        } else {
            t1 = h1;
            while (t1.next != null) {
                t1 = t1.next;
            }
            t1.next = h3;
            return h1;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        ListNode sortedList = SortList_148.sortList(head);
        System.out.println(sortedList.val + "," + sortedList.next.val + "," + sortedList.next.next.val
        + "," + sortedList.next.next.next.val + "," + sortedList.next.next.next.next.val);
    }
}
