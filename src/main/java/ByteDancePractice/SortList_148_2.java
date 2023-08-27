package ByteDancePractice;

public class SortList_148_2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 归并排序，递归
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
       return sort(head);
    }

    /**
     * 快排
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return quickSort(head);
    }

    private ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        int pi = slow.val;
        ListNode h1 = new ListNode();
        ListNode h2 = new ListNode();
        ListNode h3 = new ListNode();
        ListNode t1 = h1, t2 = h2, t3 = h3;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < pi) {
                cur.next = t1.next;
                t1.next = cur;
                t1 = t1.next;
            } else if (cur.val == pi) {
                cur.next = t3.next;
                t3.next = cur;
                t3 = t3.next;
            } else {
                cur.next = t2.next;
                t2.next = cur;
                t2 = t2.next;
            }
            cur = next;
        }
        h1 = quickSort(h1.next);
        h2 = quickSort(h2.next);
        t3.next = h2;
        h3 = h3.next;
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

    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode after = getNodeAfterMid(head);
        ListNode left = sort(head);
        ListNode right = sort(after);
        return merge(left, right);
    }

    private ListNode getNodeAfterMid(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode fast = dummy, slow = dummy;
        dummy.next = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        return next;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left != null ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        SortList_148_2 sortList_148_2 = new SortList_148_2();
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        //ListNode node = sortList_148_2.sortList(head);
        ListNode node = sortList_148_2.sortList2(head);
        System.out.println(node.val + " " + node.next.val + " " + head.next.next.val
        + " " + node.next.next.next.val + " " + node.next.next.next.next.val);
    }
}
