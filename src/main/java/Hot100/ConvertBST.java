package Hot100;

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

    static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        root = reverse(root);
        return root;
    }

    private static TreeNode reverse(TreeNode root) {
        if (root != null) {
            reverse(root.right);
            sum = sum + root.val;
            root.val = sum;
            reverse(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        System.out.println(convertBST(root));
    }
}
