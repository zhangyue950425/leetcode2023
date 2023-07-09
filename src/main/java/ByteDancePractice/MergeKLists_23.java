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

    /**
     * 两两合并
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null;
        int length = lists.length;
        for (int i = 0; i < length; i++) {
            result = merge(result, lists[i]);
        }
        return result;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null && n2 != null) {
            int val1 = n1.val;
            int val2 = n2.val;
            if (val1 < val2) {
                tail.next = n1;
                n1 = n1.next;
            } else {
                tail.next = n2;
                n2 = n2.next;
            }
            tail = tail.next;
        }
        if (n1 != null) {
            tail.next = n1;
        }
        if (n2 != null) {
            tail.next = n2;
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
        //ListNode list = MergeKLists_23.mergeKLists(lists);
        MergeKLists_23.mergeKLists2(lists);
        //  + list.next.next.next.next.next.next.next.next.val
        /*System.out.println(String.valueOf(list.val) + list.next.val + list.next.next.val + list.next.next.next.val
        + list.next.next.next.next.val + list.next.next.next.next.next.val + list.next.next.next.next.next.next.val
        + list.next.next.next.next.next.next.next.val);*/

    }


}
