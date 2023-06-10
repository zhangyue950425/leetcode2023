package TenDaysByteDancePractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectCycle {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    /**
     * 集合
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        ListNode node1 = new ListNode(0);
        node.next = node1;
        ListNode node2 = new ListNode(-4);
        node1.next = node2;
        node2.next = node;
        ListNode listNode = DetectCycle.detectCycle(head);
        System.out.println(listNode != null ? listNode.val : null);
        head = new ListNode(1);
        ListNode node3 = new ListNode(2);
        head.next = node3;
        node3.next = head;
        listNode = DetectCycle.detectCycle(head);
        System.out.println(listNode != null ? listNode.val : null);
    }
}
