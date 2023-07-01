package ByteDancePractice;

public class MergeTwoLists_21 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while (list1 != null && list2 != null) {
            int v1 = list1.val;
            int v2 = list2.val;
            if (v1 < v2) {
                result.next = new ListNode(v1);
                list1 = list1.next;
            } else {
                result.next = new ListNode(v2);
                list2 = list2.next;
            }
            result = result.next;
        }
        if (list1 != null) {
            result.next = list1;
        }
        if (list2 != null) {
            result.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        MergeTwoLists_21.mergeTwoLists(list1, list2);
    }
}
