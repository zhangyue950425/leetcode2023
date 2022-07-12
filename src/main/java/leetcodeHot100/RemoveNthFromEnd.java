package leetcodeHot100;

/**
 * 删除链表的倒数第 N 个结点:
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class RemoveNthFromEnd {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        int index = length - n;
        ListNode dummyNode = new ListNode(0, head);
        ListNode front = dummyNode;
        for (int i = 1; i <= index; i++) {
            front = front.next;
        }

        front.next = front.next.next;
        return dummyNode.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummyNode;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 1,2,3,4,5
        /*ListNode head4 = new ListNode(5, null);
        ListNode head3 = new ListNode(4, head4);
        ListNode head2 = new ListNode(3, head3);
        ListNode head1 = new ListNode(2, head2);
        ListNode head = new ListNode(1, head1);
        int n = 2;*/
        ListNode head1 = new ListNode(2, null);
        ListNode head = new ListNode(1, head1);
        int n = 2;
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        //System.out.println(removeNthFromEnd.removeNthFromEnd(head, n));
        System.out.println(removeNthFromEnd.removeNthFromEnd1(head, n));
    }
}
