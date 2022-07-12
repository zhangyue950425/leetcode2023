package leetcodeHot100;

/**
 * @author zhangyue
 * @date 2022/4/23
 * 二叉树的直径:
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 示例 :
 * 给定二叉树
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 **/
public class diameterOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int maxNode;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxNode = 1;
        depth(root);
        return maxNode - 1;
    }

    private static int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = depth(treeNode.left);
        int right = depth(treeNode.right);
        maxNode = Math.max(maxNode, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode rootLeftRight = new TreeNode(5);
        TreeNode rootLeftLeft = new TreeNode(4);
        TreeNode rootRight = new TreeNode(3, null, null);
        TreeNode rootLeft = new TreeNode(2, rootLeftLeft, rootLeftRight);
        TreeNode root = new TreeNode(1, rootLeft, rootRight);
        System.out.println(diameterOfBinaryTree(root));
    }
}
