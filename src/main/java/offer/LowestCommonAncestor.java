package offer;

public class LowestCommonAncestor {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      while (root != null) {
        if (root.val < p.val && root.val < q.val) {
          root = root.right;
        } else if (root.val > p.val && root.val > q.val) {
          root = root.left;
        } else {
          break;
        }

      }
      return root;
    }

  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
      return cur(root, p, q);
  }

  private TreeNode cur(TreeNode cur, TreeNode p, TreeNode q) {
      if (cur.val > p.val && cur.val > q.val) {
        return cur(cur.left, p, q);
      }
      if (cur.val < p.val && cur.val < q.val) {
        return cur(cur.right, p, q);
      }
      return cur;
  }

    public static void main(String[] args) {
      // root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
      // root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
      TreeNode root = new TreeNode(6);
      TreeNode left = new TreeNode(2);
      TreeNode right = new TreeNode(8);
      root.left = left;
      root.right = right;
      TreeNode leftLeft = new TreeNode(0);
      TreeNode leftRight = new TreeNode(4);
      left.left = leftLeft;
      left.right = leftRight;
      TreeNode rightLeft = new TreeNode(7);
      TreeNode rightRight = new TreeNode(9);
      right.left = rightLeft;
      right.right = rightRight;
      TreeNode leftRightLeft = new TreeNode(3);
      TreeNode leftRightRight = new TreeNode(5);
      leftRight.left = leftRightLeft;
      leftRight.right = leftRightRight;
      //System.out.println(LowestCommonAncestor.lowestCommonAncestor(root, left, right).val);
      //System.out.println(LowestCommonAncestor.lowestCommonAncestor(root, left, leftRight).val);
      LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
      //System.out.println(lowestCommonAncestor.lowestCommonAncestor2(root, left, right).val);
      System.out.println(lowestCommonAncestor.lowestCommonAncestor2(root, left, leftRight).val);
    }
}
