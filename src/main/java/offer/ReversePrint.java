package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePrint {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static int[] reversePrint(ListNode head) {
        int[] result = new int[]{};
        if (head == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        result = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            result[list.size() - (i + 1)] = list.get(i);
        }
        return result;
    }


    static List<Integer> list = new ArrayList<>();
    public static int[] reversePrint1(ListNode head) {
        reverse(head);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static void reverse(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        reverse(listNode.next);
        list.add(listNode.val);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        System.out.println(Arrays.toString(ReversePrint.reversePrint(listNode)));
        System.out.println(Arrays.toString(ReversePrint.reversePrint1(listNode)));
    }
}
