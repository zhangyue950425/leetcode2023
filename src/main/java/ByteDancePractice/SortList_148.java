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
     * 迭代归并排序
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            length++;
        }
        // h1和h2分别是每次合并头结点
        ListNode h1, h2;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre;
        // count表示每次合并的节点个数
        int count = 1;
        int count1, count2;
        // count每次double，直到大于链表长度的时候表示已经完成所有的排序
        while (count < length) {
            pre = res;
            h = res.next;
            while (h != null) {
                h1 = h;
                int i = count;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                // 说明第一组比较的链表都没有足够的长度节点
                if (i > 0) {
                    break;
                }
                i = count;
                h2 = h;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                count1 = count;
                count2 = count - i;
                while (count1 > 0 && count2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        count1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        count2--;
                    }
                    pre = pre.next;
                }
                pre.next = count1 == 0 ? h2 : h1;
                while (count1 > 0 || count2 > 0) {
                    pre = pre.next;
                    count1--;
                    count2--;
                }
                pre.next = h;
            }
            count = count * 2;
        }
        return res.next;
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
        //ListNode sortedList = SortList_148.sortList(head);
        ListNode sortedList2 = SortList_148.sortList2(head);
        /*System.out.println(sortedList.val + "," + sortedList.next.val + "," + sortedList.next.next.val
        + "," + sortedList.next.next.next.val + "," + sortedList.next.next.next.next.val);*/
        System.out.println(sortedList2.val + "," + sortedList2.next.val + "," + sortedList2.next.next.val
                + "," + sortedList2.next.next.next.val + "," + sortedList2.next.next.next.next.val);
    }
}
