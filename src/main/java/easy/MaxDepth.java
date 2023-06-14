package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * DFS:后续遍历
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        return order(root);
    }

    private static int order(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = order(root.left);
        int right = order(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * BFS:队列
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new LinkedList<>();
            for (TreeNode treeNode : queue) {
                if (treeNode.left != null) {
                    list.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.add(treeNode.right);
                }
            }
            queue = list;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(root));
        System.out.println(maxDepth.maxDepth2(root));
    }
}
