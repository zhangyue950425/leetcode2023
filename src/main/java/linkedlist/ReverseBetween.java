package linkedlist;

/**
 * 92
 */
public class ReverseBetween {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;

    private ListNode reverseN(ListNode listNode, int n) {
        if (n == 1) {
            successor = listNode.next;
            return listNode;
        }
        ListNode last = reverseN(listNode.next, n - 1);
        listNode.next.next = listNode;
        listNode.next = successor;
        return last;
    }
}
