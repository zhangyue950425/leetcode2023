package Hot100;

public class LowestCommonAncestor {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 根节点为null，或者p，q节点中有根节点，则根节点就是最近公共祖先
        if (root == null || p == root || q == root) {
            return root;
        }
        // p，q都不是根节点，则继续想左右子树分别所搜p,q，记返回值为left何right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右子树都没有搜索到说明不存在p,q节点，直接返回最近公共祖先为null
        if (left == null && right == null) {
            return null;
        }

        else if (left != null && right == null) {
            return left;
        }
        else if (right != null && left == null) {
            return right;
        } else {
            // 左右子树都能搜索到，说明p,q在根节点的两侧，那根节点肯定是最近公共祖先节点
            return root;
        }

    }

    public static void main(String[] args) {
        // p,q 不存在
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode leftLeft = new TreeNode(6);
        TreeNode leftRight = new TreeNode(2);
        root.left = left;
        root.left.left = leftLeft;
        root.left.right = leftRight;
        TreeNode leftRightLeft = new TreeNode(7);
        root.left.right.left = leftRightLeft;
        TreeNode leftRightRight = new TreeNode(4);
        root.left.right.right = leftRightRight;
        TreeNode right = new TreeNode(1);
        root.right = right;
        TreeNode rightLeft = new TreeNode(0);
        root.right.left = rightLeft;
        TreeNode rightRight = new TreeNode(8);
        root.right.right = rightRight;
        /*TreeNode p = new TreeNode(9);
        TreeNode q = new TreeNode(10);*/
        /*TreeNode p = left;
        TreeNode q = right;
        TreeNode node = LowestCommonAncestor.lowestCommonAncestor(root, p, q);
        if (node != null) {
            System.out.println(node.val);
        }*/
        /*TreeNode p = leftLeft;
        TreeNode q = leftRight;
        TreeNode node = LowestCommonAncestor.lowestCommonAncestor(root, p, q);
        if (node != null) {
            System.out.println(node.val);
        }*/
        /*TreeNode p = leftRight;
        TreeNode q = rightRight;
        TreeNode node = LowestCommonAncestor.lowestCommonAncestor(root, p, q);
        if (node != null) {
            System.out.println(node.val);
        }*/
        /*TreeNode p = rightLeft;
        TreeNode q = rightRight;
        TreeNode node = LowestCommonAncestor.lowestCommonAncestor(root, p, q);
        if (node != null) {
            System.out.println(node.val);
        }*/
        TreeNode p = right;
        TreeNode q = new TreeNode(9);
        TreeNode node = LowestCommonAncestor.lowestCommonAncestor(root, p, q);
        if (node != null) {
            System.out.println(node.val);
        }
    }
}
