package TenDaysByteDancePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReorderList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 暴力方法,借助集合存储节点信息
     * @param head
     */
    public static void reorderList(ListNode head) {
       LinkedList<ListNode> listNodeList = new LinkedList<>();
       ListNode p = head;
       while (p != null) {
           listNodeList.addLast(p);
           p = p.next;
       }
       int left = 0, right = listNodeList.size() - 1;
       while (left < right) {
           ListNode leftNode = listNodeList.get(left);
           ListNode rightNode = listNodeList.get(right);
           leftNode.next = rightNode;
           left++;
           rightNode.next = listNodeList.get(left);
           right--;
       }
       listNodeList.get(left).next = null;
    }

    public static void reorderList2(ListNode head) {
        ListNode mid = getMid(head);
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        merge(head, head2);
    }

    /**
     * 获取链表中间节点
     * @param head
     * @return
     */
    private static ListNode getMid(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p1 = dummy, p2 = head;
        while (p2 != null) {
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        return p1;
    }

    /**
     * 合并两个链表
     * @param p1
     * @param p2
     */
    private static void merge(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return;
        }
        while (p2 != null) {
            ListNode n1 = p1.next, n2 = p2.next;
            p1.next = p2;
            p2.next = n1;
            p1 = n1;
            p2 = n2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //ReorderList.reorderList(head);
        ReorderList.reorderList2(head);
    }
}
