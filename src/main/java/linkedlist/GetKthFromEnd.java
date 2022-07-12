package linkedlist;

public class GetKthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5, 和 k = 2
        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        int k = 2;
        ListNode listNode4 = new ListNode(5);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        getKthFromEnd.getKthFromEnd(listNode, k);
    }
}
