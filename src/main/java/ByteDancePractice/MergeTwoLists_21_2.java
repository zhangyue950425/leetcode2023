package ByteDancePractice;

public class MergeTwoLists_21_2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while (list1 != null && list2 != null) {
            int v1 = list1.val;
            int v2 = list2.val;
            int v = result.val;
            while (v == v1) {
                list1 = list1.next;
                v1 = list1.val;
            }
            while (v == v2) {
                list2 = list2.next;
                v2 = list2.val;
            }
            if (v1 >= v2) {
                result.next = list2;
                list2 = list2.next;
            } else {
                result.next = list1;
                list1 = list1.next;
            }
            result = result.next;
        }
        if (list1 != null) {
            int v = result.val;
            int v1 = list1.val;
            while (v == v1) {
                list1 = list1.next;
                if (list1 == null) {
                    break;
                }
                v1 = list1.val;
            }
            result.next = list1;
        }
        if (list2 != null) {
            int v = result.val;
            int v2 = list2.val;
            while (v == v2) {
                list2 = list2.next;
                if (list2 == null) {
                    break;
                }
                v2 = list2.val;
            }
            result.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoLists_21_2 mergeTwoLists_21_2 = new MergeTwoLists_21_2();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists_21_2.mergeTwoLists(list1, list2));
    }
}
