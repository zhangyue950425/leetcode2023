package Hot100;

import java.util.HashSet;
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
     * 集合，存放链表节点
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(-4);
        root.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node;
        DetectCycle detectCycle = new DetectCycle();
        System.out.println(detectCycle.detectCycle(root));
    }
}
