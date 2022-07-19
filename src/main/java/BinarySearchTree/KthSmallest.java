package BinarySearchTree;

public class KthSmallest {
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
    int result = 0;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            result = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public static void main(String[] args) {
        int k = 1;
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        TreeNode leftRight = new TreeNode(2);
        left.right = leftRight;
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(root, k));
    }
}
