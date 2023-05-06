package offer;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    static List<Integer> list = new ArrayList<>();
    public static int kthLargest(TreeNode root, int k) {
        mid(root);
        return list.get(list.size() - k);
    }

    private static void mid(TreeNode cur) {
        if (cur == null) {
            return;
        }
        mid(cur.left);
        list.add(cur.val);
        mid(cur.right);
    }

    public static void main(String[] args) {
        // root = [3,1,4,null,2], k = 1
        // root = [5,3,6,2,4,null,null,1], k = 3
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;
        System.out.println(KthLargest.kthLargest(root, k));
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(1);
        int k1 = 3;
        System.out.println(KthLargest.kthLargest(root1, k1));
    }
}
