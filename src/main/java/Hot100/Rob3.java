package Hot100;

public class Rob3 {

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

    public static int rob(TreeNode root) {
        // dp[0]表示该节点偷的最大价值，是在当前节点不偷取的情况
        // dp[1]表示该节点偷的最大价值，是在当前节点偷取的情况
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) {
            // 当前节点为空，没有价值
            return new int[]{0,0};
        }
        // 先看左右子树的价值，因为当前接口的价值和左右子树有关
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 当前节点的最大价值处理
        int[] dp = new int[2];
        // 当前节点最大价值在本节点不偷的情况，左右节点可以偷取也可以不偷取，只要取最大值就可以
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 当前节点偷取的话，左右节点不能偷取
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }

    public static void main(String[] args) {
        // 输入: root = [3,2,3,null,3,null,1]
        // 输出: 7
        // 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        Rob3 rob3 = new Rob3();
        System.out.println(rob3.rob(root));
    }
}
