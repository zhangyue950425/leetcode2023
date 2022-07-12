package leetcodeHot100;

/**
 * 二叉树的最近公共祖先:
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 */
public class LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // 3,5,1,6,2,0,8,null,null,7,4
        // p = 5, right = 1
        TreeNode q = new TreeNode(4, null, null);
        TreeNode left3 = new TreeNode(7, null, null);
        TreeNode right2 = new TreeNode(8, null, null);
        TreeNode left2 = new TreeNode(0, null, null);
        TreeNode right1 = new TreeNode(2, left3, q);
        TreeNode left1 = new TreeNode(6, null, null);
        TreeNode right = new TreeNode(1, left2, right2);
        TreeNode p = new TreeNode(5, left1, right1);
        TreeNode root = new TreeNode(3, p, right);
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, p, q).val);
    }
}
