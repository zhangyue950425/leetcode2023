package linkedlist;

/**
 * 21
 */
public class MergeTwoLists {

    public static class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // l1 = [1,2,4], l2 = [1,3,4]
        ListNode list111 = new ListNode(4, null);
        ListNode list11 = new ListNode(2, list111);
        ListNode list1 = new ListNode(1, list11);

        ListNode list222 = new ListNode(4, null);
        ListNode list22 = new ListNode(3, list222);
        ListNode list2 = new ListNode(1, list22);
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        mergeTwoLists.mergeTwoLists(list1, list2);

    }
}
