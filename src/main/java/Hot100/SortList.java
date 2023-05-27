package Hot100;

import java.util.*;

public class SortList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 暴力方法
     * @param head
     * @return
     */
    static List<ListNode> list = new ArrayList<>();
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        while (pre != null) {
            list.add(pre);
            pre = pre.next;
        }
        int[] arrays = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arrays[i] = list.get(i).val;
        }
        Arrays.sort(arrays);
        ListNode preNode = new ListNode(arrays[0]);
        ListNode node = preNode;
        for (int i = 1; i < arrays.length; i++) {
            ListNode curNode = new ListNode(arrays[i]);
            node.next = curNode;
            node = node.next;
        }
        return preNode;

    }

    /**
     * 自底向上的归并排序：从子链表长度为1开始排序，然后合并，在以长度*2排序合并
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {
            if (head == null) {
                return head;
            }
            int length = 0;
            ListNode node = head;
            while (node != null) {
                length++;
                node = node.next;
            }
            ListNode dummyHead = new ListNode(0, head);
            for (int subLength = 1; subLength < length; subLength <<= 1) {
                ListNode prev = dummyHead, curr = dummyHead.next;
                while (curr != null) {
                    ListNode head1 = curr;
                    for (int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }
                    ListNode merged = merge(head1, head2);
                    prev.next = merged;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummyHead.next;
        }

        public static ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }



    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode sortNode = SortList.sortList2(head);
        System.out.println(sortNode.val);
        System.out.println(sortNode.next.val);
        System.out.println(sortNode.next.next.val);
        System.out.println(sortNode.next.next.next.val);
    }
}
