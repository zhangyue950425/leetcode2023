package binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 889
 */
public class ConstructFromPrePost {

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

    Map<Integer, Integer> indexValMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            indexValMap.put(postorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] postorder, int postLeft, int postRight) {
        if (preLeft > preRight) {
            return null;
        }
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int leftRootVal = preorder[preLeft + 1];
        int index = indexValMap.get(leftRootVal);
        int leftSize = index - postLeft + 1;
        root.left = buildTree(preorder, preLeft + 1, preLeft + leftSize,
                postorder, postLeft, index);
        root.right = buildTree(preorder, preLeft + leftSize + 1, preRight,
                postorder, index + 1, postRight - 1);
        return root;
    }
}
