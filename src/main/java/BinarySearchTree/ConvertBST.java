package BinarySearchTree;

/**
 * 538
 */
public class ConvertBST {
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
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum = sum + root.val;
        root.val = sum;
        traverse(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = new TreeNode(0);
        TreeNode leftRight = new TreeNode(2);
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode rightLeft = new TreeNode(5);
        TreeNode rightRight = new TreeNode(7);
        right.left = rightLeft;
        right.right = rightRight;
        TreeNode leftRightRight = new TreeNode(3);
        leftRight.right = leftRightRight;
        TreeNode rightRightRight = new TreeNode(8);
        rightRight.right = rightRightRight;
        ConvertBST convertBST = new ConvertBST();
        convertBST.convertBST(root);
    }
}
