package leetcodeHot100;

/**
 * @author zhangyue
 * @date 2022/4/14
 * 合并两个有序链表:
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 **/
public class mergeTwoLists {

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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeList = new ListNode();
        ListNode tmp = mergeList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = list1 != null ? list1 : list2;
        return mergeList.next;

    }

    public static void main(String[] args) {
        ListNode list13 = new ListNode(4, null);
        ListNode list12 = new ListNode(2, list13);
        ListNode list1 = new ListNode(1, list12);

        ListNode list23 = new ListNode(4, null);
        ListNode list22 = new ListNode(3, list23);
        ListNode list2 = new ListNode(1, list22);

        System.out.println(mergeTwoLists(list1, list2).val);

        ListNode list11 = null;
        ListNode list222 = null;
        System.out.println(mergeTwoLists(list11, list222));

        ListNode list111 = null;
        ListNode list2222 = new ListNode();
        System.out.println(mergeTwoLists(list111, list2222).val);

    }
}
