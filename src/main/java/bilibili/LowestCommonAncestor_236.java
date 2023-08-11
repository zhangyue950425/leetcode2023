package bilibili;

public class LowestCommonAncestor_236 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        System.out.println(LowestCommonAncestor_236.lowestCommonAncestor(root, p, q));

    }
}
