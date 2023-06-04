package TenDaysByteDancePractice;

public class WidthOfBinaryTree {

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

    /**
     * BFS
     * @param root
     * @return
     */
    public static int widthOfBinaryTree(TreeNode root) {

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        System.out.println(WidthOfBinaryTree.widthOfBinaryTree(root));
    }
}
