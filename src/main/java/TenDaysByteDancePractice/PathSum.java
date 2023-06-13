package TenDaysByteDancePractice;

import java.util.ArrayList;
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

    static List<List<Integer>> result = new ArrayList<>();
    static Integer targetSum = 0;
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        targetSum = target;
        dfs(root, 0, new LinkedList<>());
        return result;
    }

    private static void dfs(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum - root.val) {
                result.add(new LinkedList<>(list));
            }
        }
        dfs(root.left, sum + root.val, list);
        dfs(root.right, sum + root.val, list);
        list.removeLast();
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
