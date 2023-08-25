package ByteDancePractice;

public class HasCycle_141 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle_141 hasCycle_141 = new HasCycle_141();
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = node;
        System.out.println(hasCycle_141.hasCycle(head));
        head = new ListNode(1);
        node = new ListNode(2);
        head.next = node;
        node.next = head;
        System.out.println(hasCycle_141.hasCycle(head));
        head = new ListNode(1);
        System.out.println(hasCycle_141.hasCycle(head));
    }

}
