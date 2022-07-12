package leetcodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyue
 * @date 2022/4/25
 * 两数相加:
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 **/
public class addTwoNumbers {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> l1List = new ArrayList<>();
        int l1Length = 0;
        int l2Length = 0;
        List<Integer> l2List = new ArrayList<>();
        while (l1 != null) {
            l1List.add(l1.val);
            l1 = l1.next;
            l1Length++;
        }
        while (l2 != null) {
            l2List.add(l2.val);
            l2 = l2.next;
            l2Length++;
        }
        int l1Result = 0;
        int l2Result = 0;
        for (int i = l1Length - 1; i >= 0; i--) {
            l1Result = l1Result + l1List.get(i) * Double.valueOf(Math.pow(10, i)).intValue();
        }
        for (int i = l2Length - 1; i >= 0; i--) {
            l2Result = l2Result + l2List.get(i) * Double.valueOf(Math.pow(10, i)).intValue();
        }
        int result = l1Result + l2Result;
        ListNode node = new ListNode(result % 10);
        ListNode tmp = node;
        result = result / 10;
        while (result != 0) {
            int num = result % 10;
            ListNode next = new ListNode(num);
            tmp.next = next;
            tmp = tmp.next;
            result = result / 10;
        }
        return node;
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
        ListNode l3 = new ListNode(2);
        ListNode l33 = new ListNode(4);
        l3.next = l33;
        ListNode l333 = new ListNode(9);
        l33.next = l333;
        ListNode l4 = new ListNode(5);
        ListNode l44 = new ListNode(6);
        l4.next = l44;
        ListNode l444 = new ListNode(4);
        l44.next = l444;
        ListNode l4444 = new ListNode(9);
        l444.next = l4444;
        System.out.println(addTwoNumbers(l3, l4));
    }
}
