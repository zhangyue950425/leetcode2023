package Hot100;

public class PathSum {

    public class TreeNode {
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

  int count, t;
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        dfs1(root);
        return count;
    }

    /**
     * dfs1 来搜索所有节点，复杂度为 O(n)
     * @param root
     */
    private void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    /**
     * dfs2 搜索以其为根的所有（往下的）路径，同时累加路径总和为
     * targetSum 的所有路径，复杂度为 O(n)
     * @param root
     * @param val
     */
    private void dfs2(TreeNode root, long val) {
        if (val == t) {
            count++;
        }
        if (root.left != null) {
            dfs2(root.left, val + (long) root.left.val);
        }
        if (root.right != null) {
            dfs2(root.right, val + (long) root.right.val);
        }

    }


    public void main() {
        // 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        // 输出：3
        PathSum pathSum = new PathSum();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        int targetSum = 8;
        System.out.println(pathSum.pathSum(root, targetSum));
        // [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);
        targetSum = 0;
        System.out.println(pathSum.pathSum(root, targetSum));
    }


}
