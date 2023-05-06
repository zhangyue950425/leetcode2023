package offer;

import java.util.*;

public class IsSymmetric {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true;
      }
      return recursion(root.left, root.right);
    }

  public static boolean isSymmetric2(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    // 左子树层序遍历：从左向右
    queue.offer(root.left);
    List<Integer> leftList = new ArrayList<>();
    leftList.add(root.val);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      leftList.add(node.val);
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    Integer[] leftArray = leftList.toArray(new Integer[0]);
    // 右子树层序遍历：从右向左
    List<Integer> rightList = new ArrayList<>();
    rightList.add(root.val);
    queue.clear();
    queue.offer(root.right);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      rightList.add(node.val);
      if (node.right != null) {
        queue.offer(node.right);
      }
      if (node.left != null) {
        queue.offer(node.left);
      }
    }
    Integer[] rightArray = rightList.toArray(new Integer[0]);
    // 判断数据是否完全相等
    if (leftArray.length != rightArray.length) {
      return false;
    }
    for (int i = 0; i < leftArray.length; i++) {
      if (!Objects.equals(leftArray[i], rightArray[i])) {
        return false;
      }
    }
    return true;
  }

    private static boolean recursion(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
        return true;
      }
      if (left == null || right == null || left.val != right.val) {
        return false;
      }
      return recursion(left.left, right.right)
              && recursion(left.right, right.left);
    }

    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.left.left.left = new TreeNode(5);
      root.left.left.right = new TreeNode(6);
      root.left.right.left = new TreeNode(7);
      root.left.right.right = new TreeNode(8);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);
      root.right.left.left = new TreeNode(8);
      root.right.left.right = new TreeNode(7);
      root.right.right.left = new TreeNode(6);
      root.right.right.right = new TreeNode(5);
      IsSymmetric.isSymmetric(root);
      //System.out.println(IsSymmetric.isSymmetric2(root));
    }
}
