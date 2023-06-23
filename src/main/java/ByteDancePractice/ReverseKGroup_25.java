package ByteDancePractice;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup_25 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 暴力法，先根据k拆分为多个k个节点的单链表,可能存在有一个节点数量小于k的一个单链表，每个单链表反正,再多个链表两两合并
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        List<ListNode> listNodeList = new ArrayList<>();
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int count = 0;
        while (p != null) {
            ListNode h = new ListNode(p.val);
            ListNode tmp = h;
            p = p.next;
            count++;
            if (length - count < k) {
                while (p != null) {
                    tmp.next = new ListNode(p.val);
                    tmp = tmp.next;
                    p = p.next;
                    count++;
                }
            } else {
                for (int i = 0; i < k - 1; i++) {
                    tmp.next = new ListNode(p.val);
                    tmp = tmp.next;
                    p = p.next;
                    count++;
                }
            }
            listNodeList.add(h);
        }
        int size = listNodeList.size();
        // 单链表翻转
        for (int i = 0; i < size; i++) {
            ListNode h = listNodeList.get(i);
            ListNode h1 = h;
            int len = 0;
            while (h1 != null) {
                len++;
                h1 = h1.next;
            }
            if (len < k) {
                continue;
            }
            listNodeList.set(i, reverseList(listNodeList.get(i)));
        }
        ListNode p1 = null;
        ListNode p11 = null;
        int index = 0;
        if (size > 0) {
            p1 = listNodeList.get(index);
            p11 = p1;
            while (p11.next != null) {
                p11 = p11.next;
            }
            index++;
        }
        while (index < size) {
            ListNode p111 = listNodeList.get(index);
            p11.next = p111;
            while (p11.next != null) {
                p11 = p11.next;
            }
            index++;
        }
        return p1;
    }

    /**
     * 单链表翻转：三指针处理
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 一次遍历
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                // 遍历到最后不足k的节点的话，直接返回，因为前面都出来好了，后面不足k个节点的单链表不用处理
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] listNodes = getReverse(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            pre.next = head;
            //tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private static ListNode[] getReverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 3;
        System.out.println(ReverseKGroup_25.reverseKGroup(head, k));
        System.out.println(ReverseKGroup_25.reverseKGroup2(head, k));
    }
}
