package ByteDancePractice;

import java.util.PriorityQueue;

public class MergeKLists_23_2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1 && lists[0] == null) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        int length = lists.length;
        for (int i = 0; i < length; i++) {
            if (lists[i] != null) {
                priorityQueue.add(lists[i]);
            }
        }
        ListNode resultNode = new ListNode(-1);
        ListNode p = resultNode;
        while (!priorityQueue.isEmpty()) {
            ListNode listNode = priorityQueue.poll();
            ListNode next = listNode.next;
            if (next != null) {
                priorityQueue.add(next);
            }
            listNode.next = null;
            p.next = listNode;
            p = p.next;
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        MergeKLists_23_2 mergeKLists_23_2 = new MergeKLists_23_2();
        ListNode[] lists = new ListNode[3];
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        lists[0] = listNode1;
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        lists[1] = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        lists[2] = listNode3;
        ListNode listNode = mergeKLists_23_2.mergeKLists(lists);
        System.out.println(listNode.val);
    }


}
