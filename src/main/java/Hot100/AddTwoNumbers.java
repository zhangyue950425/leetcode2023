package Hot100;

public class AddTwoNumbers {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode dum = result;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.val;
            }
            int sum = l1Val + l2Val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            result.next = new ListNode(sum);
            result = result.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        return dum.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        //AddTwoNumbers.addTwoNumbers(l1, l2);
        // 9,9,9,9,9,9,9
        // 9,9,9,9
        ListNode ll1 = new ListNode(9);
        ll1.next = new ListNode(9);
        ll1.next.next = new ListNode(9);
        ll1.next.next.next = new ListNode(9);
        ll1.next.next.next.next = new ListNode(9);
        ll1.next.next.next.next.next = new ListNode(9);
        ll1.next.next.next.next.next.next = new ListNode(9);
        ListNode ll2 = new ListNode(9);
        ll2.next = new ListNode(9);
        ll2.next.next = new ListNode(9);
        ll2.next.next.next = new ListNode(9);
        AddTwoNumbers.addTwoNumbers(ll1, ll2);
    }
}
