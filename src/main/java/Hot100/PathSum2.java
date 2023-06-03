package Hot100;

import java.util.HashMap;
import java.util.Map;

public class PathSum2 {

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
    static int count, t;
    static Map<Long, Integer> map = new HashMap<>();
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        t = targetSum;
        map.put(0L, 1);
        dfs(root, root.val);
        return count;
    }

    private static void dfs(TreeNode root, long val) {
        if (map.containsKey(val - t)) {
            count = count + map.get(val - t);
        }
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) {
            dfs(root.left, val + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, val + root.right.val);
        }
        map.put(val, map.getOrDefault(val, 0) - 1);
    }

    public static void main(String[] args) {
        PathSum2 pathSum = new PathSum2();
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
        System.out.println(PathSum2.pathSum(root, targetSum));
    }
}
