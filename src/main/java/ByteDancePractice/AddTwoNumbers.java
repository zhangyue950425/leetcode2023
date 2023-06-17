package ByteDancePractice;

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
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null || l2 != null) {
            int sum = 0 + carry;
            // 进位重置
            carry = 0;
            if (l1 != null) {
                int v1 = l1.val;
                sum = sum + v1;
            }
            if (l2 != null) {
                int v2 = l2.val;
                sum = sum + v2;
            }
            // 保存进位
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            p.next = node;
            p = p.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        // 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        // 输出：[8,9,9,9,0,0,0,1]
        l1 = new ListNode(9);
    }
}
