package offer;

public class DeleteNode {

    public static class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode pre = dum;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                break;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dum.next;
    }

    public static void main(String[] args) {
        // 4,5,1,9
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        int val = 5;
        System.out.println(DeleteNode.deleteNode(listNode, val));
        // -3,5,-99
        ListNode head = new ListNode(-3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(-99);
        val = -3;
        System.out.println(DeleteNode.deleteNode(head, val));
    }
}
