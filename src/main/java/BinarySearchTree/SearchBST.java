package BinarySearchTree;

public class SearchBST {
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
    public TreeNode searchBST(TreeNode root, int val) {
         if (root == null) {
             return null;
         }
         if (root.val == val) {
             return root;
         }
         if (root.val > val) {
             return searchBST(root.left, val);
         }
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
         TreeNode root = new TreeNode(4);
         TreeNode left = new TreeNode(2);
         TreeNode right = new TreeNode(7);
         root.left = left;
         root.right = right;
         TreeNode leftLeft = new TreeNode(1);
         TreeNode leftRight = new TreeNode(3);
        left.left = leftLeft;
        left.right = leftRight;
        int target = 2;
        SearchBST searchBST = new SearchBST();
        searchBST.searchBST(root, target);
    }
}
