package ByteDancePractice;


public class SumNumbers_129 {

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
     * DFS
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = dfs(root.left, sum);
        int right = dfs(root.right, sum);
        return left + right;
    }

    public static void main(String[] args) {
        SumNumbers_129 sumNumbers_129 = new SumNumbers_129();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers_129.sumNumbers(root));
    }

}
