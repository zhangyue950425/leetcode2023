package ByteDancePractice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists_23 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 优先队列
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (!queue.isEmpty()) {
            node.next = queue.poll();
            node = node.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        ListNode[] lists = new ListNode[] {list1, list2, list3};
        ListNode list = MergeKLists_23.mergeKLists(lists);
        //  + list.next.next.next.next.next.next.next.next.val
        System.out.println(String.valueOf(list.val) + list.next.val + list.next.next.val + list.next.next.next.val
        + list.next.next.next.next.val + list.next.next.next.next.next.val + list.next.next.next.next.next.next.val
        + list.next.next.next.next.next.next.next.val);

    }


}
