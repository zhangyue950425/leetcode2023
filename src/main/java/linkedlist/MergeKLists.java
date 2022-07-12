package linkedlist;

import java.util.PriorityQueue;

/**
 * 23
 */
public class MergeKLists {

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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode listNode = priorityQueue.poll();
            p.next = listNode;
            if (listNode.next != null) {
                priorityQueue.add(listNode.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode listNode33 = new ListNode(6, null);
        ListNode listNode3 = new ListNode(2, listNode33);
        ListNode listNode222 = new ListNode(4, null);
        ListNode listNode22 = new ListNode(3, listNode222);
        ListNode listNode2 = new ListNode(1, listNode22);
        ListNode listNode111 = new ListNode(5, null);
        ListNode listNode11 = new ListNode(4, listNode111);
        ListNode listNode1 = new ListNode(1, listNode11);
        ListNode[] lists = new ListNode[3];
        lists[0] = listNode1;
        lists[1] = listNode2;
        lists[2] = listNode3;
        MergeKLists mergeKLists = new MergeKLists();
        mergeKLists.mergeKLists(lists);
    }
}
