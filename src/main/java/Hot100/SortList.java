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

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        SortList.sortList(head);
    }
}
