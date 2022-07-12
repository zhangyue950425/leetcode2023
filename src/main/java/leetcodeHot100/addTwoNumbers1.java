package leetcodeHot100;

/**
 * @author zhangyue
 * @date 2022/4/25
 **/
public class addTwoNumbers1 {

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

    public static ListNode addTwoNumbers(addTwoNumbers.ListNode l1, addTwoNumbers.ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        // l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] [8,9,9,9,0,0,0,1]
        /*ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        l1.next = l11;
        ListNode l111 = new ListNode(9);
        l11.next = l111;
        ListNode l1111 = new ListNode(9);
        l111.next = l1111;
        ListNode l11111 = new ListNode(9);
        l1111.next = l11111;
        ListNode l111111 = new ListNode(9);
        l11111.next = l111111;
        ListNode l1111111 = new ListNode(9);
        l111111.next = l1111111;
        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        l2.next = l22;
        ListNode l222 = new ListNode(9);
        l22.next = l222;
        ListNode l2222 = new ListNode(9);
        l222.next = l2222;
        System.out.println(addTwoNumbers(l1, l2).val);*/

        // [2,4,9]
        // [5,6,4,9]
        addTwoNumbers.ListNode l3 = new addTwoNumbers.ListNode(2);
        addTwoNumbers.ListNode l33 = new addTwoNumbers.ListNode(4);
        l3.next = l33;
        addTwoNumbers.ListNode l333 = new addTwoNumbers.ListNode(9);
        l33.next = l333;
        addTwoNumbers.ListNode l4 = new addTwoNumbers.ListNode(5);
        addTwoNumbers.ListNode l44 = new addTwoNumbers.ListNode(6);
        l4.next = l44;
        addTwoNumbers.ListNode l444 = new addTwoNumbers.ListNode(4);
        l44.next = l444;
        addTwoNumbers.ListNode l4444 = new addTwoNumbers.ListNode(9);
        l444.next = l4444;
        System.out.println(addTwoNumbers(l3, l4));
    }
}
