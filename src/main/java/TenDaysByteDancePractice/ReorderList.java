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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReorderList.reorderList(head);
    }
}
