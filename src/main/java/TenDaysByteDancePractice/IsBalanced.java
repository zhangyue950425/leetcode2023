package TenDaysByteDancePractice;

public class IsBalanced {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static boolean isBalanced(TreeNode root) {
      return recur(root) != -1;
    }

    private static int recur(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = recur(root.left);
      if (left == -1) {
        return -1;
      }
      int right = recur(root.right);
      if (right == -1) {
        return -1;
      }
      return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(IsBalanced.isBalanced(root));
    // 1,2,2,3,3,null,null,4,4
    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    root.left.left.right = new TreeNode(4);
    System.out.println(IsBalanced.isBalanced(root));
  }
}
