package offer;

import java.util.LinkedList;
import java.util.List;

public class PathSum {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  static LinkedList<List<Integer>> result = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return result;
    }

    private static void recur(TreeNode cur, int tar) {
        if (cur == null) {
            return;
        }
        tar = tar - cur.val;
        path.add(cur.val);
        if (tar == 0 && cur.left == null && cur.right == null) {
            result.add(new LinkedList<>(path));
        }
        recur(cur.left, tar);
        recur(cur.right, tar);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int target = 22;
        System.out.println(PathSum.pathSum(root, target));
    }
}
