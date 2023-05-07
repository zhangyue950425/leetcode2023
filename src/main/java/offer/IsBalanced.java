package offer;

public class IsBalanced {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static boolean isBalanced(TreeNode root) {
      if (height(root) == -1) {
        return false;
      }
      return true;
      /*if (heightReduce(root) > 1) {
        return false;
      }
      return true;*/
    }

    private static int height(TreeNode cur) {
      if (cur == null) {
        return 0;
      }
      int leftHeight = height(cur.left);
      if (leftHeight == -1) {
        return -1;
      }
      int rightHeight = height(cur.right);
      if (rightHeight == -1) {
        return -1;
      }
      return Math.abs(leftHeight - rightHeight) < 2? Math.max(leftHeight, rightHeight) + 1 : -1;
    }

  private static int heightReduce(TreeNode cur) {
    if (cur == null) {
      return 0;
    }
    int leftHeight = heightReduce(cur.left);
    int rightHeight = heightReduce(cur.right);
    return Math.abs(leftHeight - rightHeight);
  }

    public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);
      //System.out.println(IsBalanced.isBalanced(root));
      //System.out.println(IsBalanced.isBalanced(root));
      TreeNode root1 = new TreeNode(1);
      root1.left = new TreeNode(2);
      root1.right = new TreeNode(2);
      root1.left.left = new TreeNode(3);
      root1.left.right = new TreeNode(3);
      root1.left.left.left = new TreeNode(4);
      root1.left.left.right = new TreeNode(4);
      root1.left.left.left.left = new TreeNode(5);
      root1.left.left.left.right = new TreeNode(5);
      System.out.println(IsBalanced.isBalanced(root1));
    }
}
