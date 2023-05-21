package Hot100;

public class DetectCycle {
    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
         }
      }
    public static ListNode detectCycle(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        DetectCycle detectCycle = new DetectCycle();
        System.out.println(detectCycle.detectCycle(root));
    }
}
