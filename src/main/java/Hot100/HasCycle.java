package Hot100;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    /**
     * 集合，遍历链表放入集合中，如果存在环的话一定会遍历到重复节点，如果遍历到重复节点则直接返回true
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            ListNode node = head.next;
            if (set.contains(node)) {
                return true;
            }
            set.add(node);
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode fast = head.next, slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node;
        HasCycle hasCycle = new HasCycle();
        System.out.println(hasCycle.hasCycle(head));
        System.out.println(HasCycle.hasCycle2(head));
        head = new ListNode(1);
        System.out.println(HasCycle.hasCycle(head));
        System.out.println(HasCycle.hasCycle2(head));
    }
}
