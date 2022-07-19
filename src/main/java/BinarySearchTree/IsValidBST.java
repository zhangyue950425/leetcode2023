package BinarySearchTree;

public class IsValidBST {

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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(root));
        root = new TreeNode(5);
        left = new TreeNode(1);
        right = new TreeNode(4);
        root.left = left;
        root.right = right;
        TreeNode rightLeft = new TreeNode(3);
        TreeNode rightRight = new TreeNode(6);
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(isValidBST.isValidBST(root));
        root = new TreeNode(10);
        left = new TreeNode(5);
        right = new TreeNode(15);
        root.left = left;
        root.right = right;
        rightLeft = new TreeNode(6);
        rightRight = new TreeNode(20);
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(isValidBST.isValidBST(root));
    }
}
