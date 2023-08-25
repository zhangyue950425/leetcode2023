package ByteDancePractice;

public class MaxPathSum_124_2 {

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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    /**
     * 返回当前节点能为父节点提供的最大价值
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);
        max = Math.max(root.val + leftVal + rightVal, max);
        return Math.max(Math.max(root.val + leftVal, root.val + rightVal), 0);
    }

    public static void main(String[] args) {
        MaxPathSum_124_2 maxPathSum_124_2 = new MaxPathSum_124_2();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum_124_2.maxPathSum(root));
    }
}
