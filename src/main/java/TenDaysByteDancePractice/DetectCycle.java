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

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        // 快慢指针fast和slow，fast每次走两步，slow每次走一步
        ListNode fast = head, slow = head;
        // fast指针和slow指针第一次相遇的时候
        while (true) {
            // 无环
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            // 第一次相遇
            if (fast == slow) {
                break;
            }
        }
        // 第二次相遇
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
        ListNode listNode1 = DetectCycle.detectCycle2(head);
        System.out.println(listNode != null ? listNode.val : null);
        System.out.println(listNode1 != null ? listNode1.val : null);
        head = new ListNode(1);
        ListNode node3 = new ListNode(2);
        head.next = node3;
        node3.next = head;
        listNode = DetectCycle.detectCycle(head);
        listNode1 = DetectCycle.detectCycle2(head);
        System.out.println(listNode != null ? listNode.val : null);
        System.out.println(listNode1 != null ? listNode1.val : null);
    }
}
