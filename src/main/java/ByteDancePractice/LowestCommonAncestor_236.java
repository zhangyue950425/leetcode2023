package ByteDancePractice;

public class LowestCommonAncestor_236 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestor_236 lowestCommonAncestor_236 = new LowestCommonAncestor_236();
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        root.left = p;
        root.right = q;
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode result = lowestCommonAncestor_236.lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
        TreeNode root1 = new TreeNode(3);
        TreeNode p1 = new TreeNode(5);
        TreeNode q1 = new TreeNode(4);
        root1.left = p1;
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = q1;
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        TreeNode result1 = lowestCommonAncestor_236.lowestCommonAncestor(root1, p1, q1);
        System.out.println(result1.val);
        TreeNode root2 = new TreeNode(1);
        TreeNode p2 = root2;
        TreeNode q2 = new TreeNode(2);
        root2.left = q2;
        TreeNode result2 = lowestCommonAncestor_236.lowestCommonAncestor(root2, p2, q2);
        System.out.println(result2.val);
    }
}
